import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;

class getCells {

    ArrayList<String> famList; // Lists all plant families
    ArrayList<String> charList; // lists plant character options
    ArrayList<String> charTypeList; // Lists char type
    ArrayList<Integer> charTypeListPosition;

    public void addToTwoDArrayList(String charTypeString, int charTypePosition) {
        charTypeList.add(charTypeString);
        charTypeListPosition.add(charTypePosition);
    }

    ArrayList<String> plantFamInfo; // Lists all characters of a plant family
    String pFI; // String of plantFamInfo
    Workbook wb;
    Sheet sheet;


    //creates an array with all the plant families in it
    public void famListCreater() {

        try (Workbook wb = WorkbookFactory.create(new File
                ("src/dupex.xlsx"))) {
            Sheet sheet = wb.getSheetAt(0);

            famList = new ArrayList<>();
            int rowStart = sheet.getFirstRowNum();
            int rowEnd = sheet.getLastRowNum();

            for (int i = rowStart + 2; i <= rowEnd; i++) {
                Row row = sheet.getRow(i);

                int j = 0;
                Cell cell = row.getCell(j);
                DataFormatter df = new DataFormatter();
                String value = df.formatCellValue(cell);
                famList.add(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //creates an array with all the plant characters in it
    public void charTypeListCreater() {
        try (
//                BufferedReader br = new BufferedReader(new InputStreamReader(
//                        ClassLoader.getSystemClassLoader()
//                                .getResourceAsStream("resource/test.txt")));
               // InputStream in = getClass().getResourceAsStream("src/dupex.xlsx");

                Workbook wb = WorkbookFactory.create(new File("src/dupex.xlsx"))) {
            Sheet sheet = wb.getSheetAt(0);

            charList = new ArrayList<>();
            charTypeList = new ArrayList<>();
            charTypeListPosition = new ArrayList<>();

            int charTypeRow = 0; //i
            Row row = sheet.getRow(charTypeRow);
//            int charTypeRowPlusOne = charTypeRow + 1; //i+1
//            Row charRow = sheet.getRow(charTypeRowPlusOne);
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                //System.out.println(j);
                DataFormatter df = new DataFormatter();
                String value = df.formatCellValue(cell);
                //System.out.println("a" + value);

                if (!value.isEmpty()) {
//                        charTypeList.add(value);
                    addToTwoDArrayList(value, j);
                    // gets char options of a charType ie habitat to terrestrial, aquatic...

//                        //j is the column start and column end is unknown
//                        int charStart = j;
//                        int charEnd = j; // doesnt need to be set to j
//
//                        //set charEnd value
//                        System.out.println(charEnd);
//                        Cell plusOne = row.getCell(charEnd+1); //looks at the next column
//                        String valuePlusOne = df.formatCellValue(plusOne); // makes it a string
//                        while(valuePlusOne.isEmpty() && !valuePlusOne.equals("END")){ // boolean to determine if the next char type HAS NOT begun
//
//                            charEnd = charEnd+1; // modifying char end
//                            plusOne  = row.getCell(charEnd +1); // selects next cell
//                            valuePlusOne = df.formatCellValue(plusOne); // creating a new string for the while loop
//
//                        }
//                        System.out.println(charEnd);
//
//                        for(int x = charStart; x == charEnd; x++){
//                            //list char options
//                            Cell charCell = charRow.getCell(x);
//                            String charValue = df.formatCellValue(charCell);
////                            charList.add(charValue);
//                        }
//
                }
            }
            //for(int i = 0; i < 10; i++){
            //for (int j = 0; j <=1; j++){

            //}
            //}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //creates an array of chars
    public ArrayList<String> charListCreater() {
        ArrayList<String> cLC = new ArrayList<>();

        try (Workbook wb = WorkbookFactory.create(new File("src/dupex.xlsx"))) {
            Sheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(1);

            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                DataFormatter df = new DataFormatter();
                String value = df.formatCellValue(cell);
                cLC.add(value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return cLC;
        }

    }

    //25th nov for deadline
    //Retrieves info about a plantfamily
    public void famInfo(String fam) {
//        System.out.println(fam);
        int rowIndex = famList.indexOf(fam) + 2;

        try (Workbook wb = WorkbookFactory.create(new File
                ("src/dupex.xlsx"))) {
            Sheet sheet = wb.getSheetAt(0);

            plantFamInfo = new ArrayList<>();
            plantFamInfo.add("Facts about " + fam);
            Row characteristics = sheet.getRow(1);
            Row row = sheet.getRow(rowIndex);

            for (int j = 2; j < row.getLastCellNum(); j++) {
                // characteristics
                Cell chars = characteristics.getCell(j);
                DataFormatter dataF = new DataFormatter();
                String charValue = dataF.formatCellValue(chars);

                Cell cell = row.getCell(j);
                DataFormatter df = new DataFormatter();
                String value = df.formatCellValue(cell);

                if (!value.isEmpty()) {
                    if(value.equals("x")){
                        plantFamInfo.add("\n" + charValue + " occurs");
                    }
                    else{
                        plantFamInfo.add("\n" + charValue + " is " + value);
                    }

                }


            }
            pFI = plantFamInfo.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Retrieves info about a plantfamily
    public ArrayList<String> famInfoGame(String fam) {
//        System.out.println(fam);
        ArrayList<String> plantFamInfoG = new ArrayList<>();
        int rowIndex = famList.indexOf(fam) + 2;

        try (Workbook wb = WorkbookFactory.create(new File
                ("src/dupex.xlsx"))) {
            Sheet sheet = wb.getSheetAt(0);


            //plantFamInfo.add("Facts about " + fam);
            Row characteristics = sheet.getRow(1);
            Row row = sheet.getRow(rowIndex);

            for (int j = 2; j < row.getLastCellNum(); j++) {
                // characteristics
                Cell chars = characteristics.getCell(j);
                DataFormatter dataF = new DataFormatter();
                String charValue = dataF.formatCellValue(chars);

                Cell cell = row.getCell(j);
                DataFormatter df = new DataFormatter();
                String value = df.formatCellValue(cell);

                if (!value.isEmpty()) {
                    if(value.equals("x")){
                        plantFamInfoG.add(charValue);
                    }
                    else{
                        plantFamInfoG.add(charValue + " is " + value);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plantFamInfoG;
    }

    public ArrayList getCharColumn(int column) {
        ArrayList<String> data = new ArrayList<>();

        try (Workbook wb = WorkbookFactory.create(new File("src/dupex.xlsx"))) {
            Sheet sheet = wb.getSheetAt(0);

            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                int j = column;
                    Cell cell = row.getCell(j);
                    if(cell == null){
                        data.add("nope");
                    }
                    else {
                DataFormatter df = new DataFormatter();
                String value = df.formatCellValue(cell);
                        data.add(value);
                    }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList getData(int rowStart, int rowEnd, int colStart, int colEnd) {
        ArrayList<String> data = new ArrayList<>();

        try (Workbook wb = WorkbookFactory.create(new File("C:\\Users\\Molly\\Documents\\Thesis\\Dupe.xlsx"))) {
            Sheet sheet = wb.getSheetAt(0);

            for (int i = rowStart; i <= rowEnd; i++) {
                Row row = sheet.getRow(i);

                for (int j = colStart; j < colEnd; j++) {
                    Cell cell = row.getCell(j);
                    DataFormatter df = new DataFormatter();
                    String value = df.formatCellValue(cell);
                    data.add(value);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}

//General Formula Used
//    public void x(){
//
//        try (Workbook wb = WorkbookFactory.create(new File("C:\\Users\\Molly\\Documents\\Thesis\\Dupe.xlsx"))) {
//            Sheet sheet = wb.getSheetAt(0);
//
//            int rowStart = sheet.getFirstRowNum();
//            int rowEnd = sheet.getLastRowNum();
//
//            for (int i = rowStart; i <= rowEnd; i++) {
//                Row row = sheet.getRow(i);
//
//                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
//                    Cell cell = row.getCell(j);
//                    //System.out.println(j);
//                    DataFormatter df = new DataFormatter();
//                    String value = df.formatCellValue(cell);
//                    //System.out.println(value);
//
//                }
//                //System.out.println("-----------");
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
