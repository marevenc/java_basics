import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

public class RedisStorage {
    private RedissonClient redisson;

    private RKeys rKeys;

    private RScoredSortedSet<String> users;

    private final static String KEY = "USERS";

    void init(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try{
            redisson = Redisson.create(config);
        } catch (RedisConnectionException e){
            System.out.println("Не удалось подключиться к Redis");
            System.out.println(e.getMessage());
        }
        rKeys = redisson.getKeys();
        users = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void shutdown(){
        redisson.shutdown();
    }

    void addUser(int userId){
        users.add(userId, String.valueOf(userId));
    }

//    void pullUser(int userId){
//        users.
//    }
    int calculateUsersNumber(){
        return users.count(Double.NEGATIVE_INFINITY, true, Double.POSITIVE_INFINITY, true);
    }

    Double getUser(int userId){
        return users.getScore(String.valueOf(userId));
    }
}
