import java.util.ArrayList;
import java.util.Arrays;

public class Probability {

    String[] easyChar = {"water", "actino", "zygo", "No chlorophyll", "Panicle"};
    String[] commonFam = {"Pinaceae", "Urticaceae", "Asteraceae"};
    double probabilityNumber;
    ArrayList<String> allTheCharsChosen = new ArrayList<>();
    ArrayList<String> allPossibleFam = new ArrayList<>();

    //input is a char type

    public String charWeight (String chosenChar, boolean boo) {
        //allTheCharsChosen.add(chosenChar); //need method when unselected
        System.out.println(allTheCharsChosen.size());
        if (allTheCharsChosen.size() != 0){
            if (Arrays.stream(easyChar).anyMatch(chosenChar::equals) && boo) {
                probabilityNumber = (probabilityNumber * (allTheCharsChosen.size() - 1) + 0.7) / (allTheCharsChosen.size());
                System.out.println(probabilityNumber);
            } else if (!Arrays.stream(easyChar).anyMatch(chosenChar::equals) && boo){
                probabilityNumber = (probabilityNumber * (allTheCharsChosen.size() - 1) + 0.5) / (allTheCharsChosen.size());
                System.out.println(probabilityNumber);
            }
            else if(Arrays.stream(easyChar).anyMatch(chosenChar::equals) && !boo){
                probabilityNumber = (probabilityNumber * (allTheCharsChosen.size() + 1) - 0.7) / (allTheCharsChosen.size());
                System.out.println(probabilityNumber);
            } else if (!Arrays.stream(easyChar).anyMatch(chosenChar::equals) && !boo){
            probabilityNumber = (probabilityNumber * (allTheCharsChosen.size()+ 1) - 0.5) / (allTheCharsChosen.size());
            System.out.println(probabilityNumber);
            }
            if (allTheCharsChosen.size() < 4 || probabilityNumber < 0.55) {
                System.out.println(allTheCharsChosen);
                return "say to imput more char";
            } else {
                //search families
                return possibleFam(allTheCharsChosen);
            }
        }
        else{
            probabilityNumber = 0;
            return "0 say to input more char";
        }

    }
    private String possibleFam (ArrayList<String> allTheCharsChosen){
        //query the spreadsheet

                    for (int i = 0; i <= allTheCharsChosen.size(); i++){ //length is number of characteristics selected
                        String characteristic = allTheCharsChosen.get(i);
                        //find column
                        getCells a = new getCells();
                        ArrayList<String> charList = a.charListCreater();
                        ArrayList<Integer> ints = new ArrayList<>();
                        int columnInt = charList.indexOf(characteristic) +2;
                        //find all null families (of those in arraylist)
                        a.famListCreater();
                        ArrayList<String> fList = a.famList;

                        ArrayList<String> charColumnList = a.getCharColumn(columnInt);
                        for(int q = 0; q <= 120; q++){//charColumnList.size()
                            if(charColumnList.get(q).equals("nope")){ // every null cell??
                    ints.add(q);
                }
            }
            for (int o = ints.size()-1; o >= 0; o--){
                int removeint = ints.get(o);
                fList.remove(removeint);
            }
            if(fList.isEmpty()){
                return ":(";
            }
            else{
                return fList.toString();
            }
        }
        return "this should not be a return";
    }

}
