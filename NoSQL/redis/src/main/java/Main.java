import java.util.Random;

public class Main {

    private static final int USERS = 20;

    private static final int SLEEP = 1000;

    private static final int SHOWS = 10;

    private static void log(Double user){
        String log = String.format("На главной странице показываем пользователя %.0f", user);
        System.out.println(log);
    }

    public static void main(String[] args) throws InterruptedException {
        RedisStorage redis = new RedisStorage();
        redis.init();

        for(int i = 1; i <= USERS; i++){
            redis.addUser(i);
        }

        while(true){
            int countShows = 1;
            int ignoreUser = -1;
            for(int i = 1; i <= redis.calculateUsersNumber(); i++){

                if(countShows == SHOWS){
                    int userId = new Random().nextInt(USERS);
                    System.out.printf("Пользователь %.0f оплатил платную услугу \n", redis.getUser(userId));
                    log(redis.getUser(userId));
                    countShows = 0;
                    ignoreUser = userId;
                    Thread.sleep(SLEEP);
                }

                if(i != ignoreUser){
                    log(redis.getUser(i));
                    countShows++;
                }
            }
            ignoreUser = -1;
        }
    }
}
