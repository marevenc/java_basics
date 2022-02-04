import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {
    String pathMovementsCsv;

    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
    }

    public double getExpenseSum() {
        double expenseSum = 0.0;
        ArrayList<BankOperation> operations = loadOperationsFromFile();
        for(BankOperation operation : operations){
            expenseSum += operation.getOutgo();
        }
        return expenseSum;
    }

    public double getIncomeSum() {
        double incomeSum = 0.0;
        ArrayList<BankOperation> operations = loadOperationsFromFile();
        for(BankOperation operation : operations){
            incomeSum += operation.getIncome();
        }
        return incomeSum;
    }

    public ArrayList<BankOperation> loadOperationsFromFile(){
        ArrayList<BankOperation> operations = new ArrayList<>();

        try{
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            lines.remove(0);
            for(String line : lines){
                String [] fragments;
                if(line.contains("\"")){
                    fragments = splitLineWithQuotes(line);
                } else{
                    fragments = line.split(",");
                }

                if(fragments.length != 8){
                    System.out.println("Wrong line: " + line);
                    continue;
                }

                operations.add(new BankOperation(
                        fragments[0],
                        fragments[1],
                        fragments[2],
                        fragments[3],
                        fragments[4],
                        fragments[5],
                        Double.parseDouble(fragments[6]),
                        Double.parseDouble(fragments[7])
                ));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return operations;
    }

    public String [] splitLineWithQuotes(String line){
        Pattern p = Pattern.compile("(\".*?),(.*?\")");
        Matcher m = p.matcher(line);
        StringBuffer sb = new StringBuffer();
        while (m.find()){
            m.appendReplacement(sb, m.group().replace(",", "."));
        }
        m.appendTail(sb);
        line = sb.toString();
        String [] fragments = line.split(",");
        for(int i = 0; i < fragments.length; i++){
            if(fragments[i].contains("\"")){
                String tmp = fragments[i].replaceAll("\"", "");
                fragments[i] = tmp;
            }
        }
        return fragments;
    }

    public HashMap<String, Double> getExpensesDivided(){
        ArrayList<BankOperation> operations = loadOperationsFromFile();
        HashMap<String, Double> organisationExpenses = new HashMap<>();
        for(BankOperation operation : operations){
            if(operation.getIncome() == 0){
                String organisation = parseDescription(operation.getDescription());
                if(!organisationExpenses.containsKey(organisation)){
                    organisationExpenses.put(organisation, operation.getOutgo());
                } else {
                    Double tmp = organisationExpenses.get(organisation);
                    tmp += operation.getOutgo();
                    organisationExpenses.put(organisation, tmp);
                }
                //String str = parseDescription(operation.getDescription());
            }

        }
        return organisationExpenses;


    }

    public String parseDescription(String line){
        String[] fragments;
        if(line.contains("\\")){
            fragments = line.split("\\\\");
        } else {
            fragments = line.split("/");
        }
        String[] organisation = fragments[fragments.length - 1].split("   ");
        return organisation[0];
    }
}
