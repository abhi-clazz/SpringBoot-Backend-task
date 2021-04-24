package com.saveo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.saveo.model.SaveoModel;


public class UploadCSV {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "c_name", "c_batch_no", "d_expiry_date", "n_balance_qty","c_packaging","c_unique_code","c_schemes","n_mrp","c_manufacturer","hsn_code" };

  public static boolean isCSVFormat(MultipartFile file) {
 System.out.println(file.getContentType());
    if (TYPE.equals(file.getContentType())
    		|| file.getContentType().equals("application/vnd.ms-excel")) {
      return true;
    }

    return false;
  }

  public static List<SaveoModel> dbUpload(InputStream is) 
  {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<SaveoModel> list = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
    	  SaveoModel saveoModel = new SaveoModel(
    			 null,
             csvRecord.get("c_name"),
              csvRecord.get("c_batch_no"),
             csvRecord.get("d_expiry_date"),
            Integer.parseInt( csvRecord.get("n_balance_qty")),

             csvRecord.get("c_packaging"),

             csvRecord.get("c_unique_code"),

             csvRecord.get("c_schemes"),

             Double.parseDouble(csvRecord.get("n_mrp")),

              csvRecord.get("c_manufacturer"),
              csvRecord.get("hsn_code")
           
            );

    	  list.add(saveoModel);
      }

      return list;
    } catch (IOException e) {
      throw new RuntimeException( e.getMessage());
    }
  }

 
}
