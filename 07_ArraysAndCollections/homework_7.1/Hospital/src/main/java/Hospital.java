public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float [] patientsTemperatures = new float[patientsCount];
        for(int i = 0; i < patientsCount; i++){
            patientsTemperatures[i] = (float)(Math.round((32.0 + 8.0 * Math.random())*10)/10.0);
        }

        return patientsTemperatures;
    }

    public static String getReport(float[] temperatureData) {
        StringBuilder builder = new StringBuilder();
        int healthyCount = 0;
        float sumTemp = 0;
        for(int i = 0; i < temperatureData.length; i++){
            if((temperatureData[i] > 36.2 && temperatureData[i] < 36.9
                    || Math.abs(temperatureData[i] - 36.2) < 0.01
                    || Math.abs(temperatureData[i] - 36.9) < 0.01)){
                healthyCount++;
            }
            sumTemp += temperatureData[i];
            builder.append(temperatureData[i]).append(" ");
        }

        float averageTemp = (float)(Math.round(sumTemp / temperatureData.length * 100) / 100.0);
        String report =
                "Температуры пациентов: " + builder.toString().trim() +
                        "\nСредняя температура: " + averageTemp +
                        "\nКоличество здоровых: " + healthyCount;

        return report;
    }
}
