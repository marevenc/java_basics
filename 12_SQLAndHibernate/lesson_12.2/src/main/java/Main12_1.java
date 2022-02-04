//import java.sql.*;
//
//public class Main12_1 {
//    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/skillbox";
//        String user = "root";
//        String pass = "qqqq400008000";
//        try {
//            Connection connection = DriverManager.getConnection(url, user, pass);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select course_name, count(student_name) as count_students, max(month(subscription_date))-min(month(subscription_date))+1 as count_months  from purchaselist group by course_name");
//
//            while (resultSet.next()){
//                String courseName = resultSet.getString("course_name");
//                int countStudents = Integer.parseInt(resultSet.getString("count_students"));
//                int countMonths = Integer.parseInt(resultSet.getString("count_months"));
//                double averageStudentsPerMonth = ((double)countStudents)/countMonths;
//                System.out.println(courseName + " = " + String.format("%.2f",averageStudentsPerMonth));
//            }
//
//            resultSet.close();
//            statement.close();
//            connection.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//}
