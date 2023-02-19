package com.amjadprojects.course.trainingcourse.Services;


import com.amjadprojects.course.trainingcourse.models.Address;
import com.amjadprojects.course.trainingcourse.models.Employee;
import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeesServices

{
   final
   EmpsRep empsRep;

   final
   AdressRep adressRep;



    public EmployeesServices(EmpsRep empsRep, AdressRep adressRep) {
        this.empsRep = empsRep;
        this.adressRep = adressRep;
    }

    public Long updateSalary(Long salary){

        return (long) (salary + (salary * 0.05));

    }

    public Document generate(Employee employee, HttpServletResponse response) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);

        Paragraph paragraph1 = new Paragraph("Employee Details", fontTiltle);

        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph1);

        PdfPTable table = new PdfPTable(5);

        table.setWidthPercentage(100f);
        table.setWidths(new int[] {3,3,3,3,3});
        table.setSpacingBefore(5);

        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Employee Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Salary", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Password", font));
        table.addCell(cell);

            table.addCell(String.valueOf(employee.getId()));

            table.addCell(employee.getFullName());

            table.addCell(String.valueOf(employee.getSalary()));

            table.addCell(employee.getEmail());

            table.addCell(employee.getPassword());

        // Adding the created table to the document
        document.add(table);
        // Closing the document
        document.close();

        return document;
    }
    public String gettime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        return dateFormat.format(new Date());
    }


    public boolean takevaction(Long empid,Long numofdays){

        Employee emp = empsRep.getReferenceById(empid);


        Long vacdays = emp.getVacationBalance();


        System.out.println("Vac Days : - " + vacdays);


        if (vacdays >= numofdays && vacdays > 0 && numofdays > 0){

            vacdays = vacdays - numofdays;

            System.out.println(" new Vac Days : - " + vacdays);

            emp.setVacationBalance(vacdays);

            empsRep.save(emp);

            return true;
        }


        return false;
    }


    public  Double inseartLeaveingHours(Long empid , Double hours){

        Employee emp = empsRep.getReferenceById(empid);

        emp.setLeavingHours(hours);

        empsRep.save(emp);

        return emp.getLeavingHours();
    }


  public List<Employee> getbyaddress(Long id){
      Address address = adressRep.getReferenceById(id);
      return empsRep.findAllByAddresses(address);
  }



  public Boolean addAddresstoEmp(Long id,Address address){


        try {

            Employee employee = empsRep.getReferenceById(id);

            adressRep.save(address);

            employee.addresses.add(address);

            empsRep.save(employee);

            return true;

        }catch (Exception e){

            System.out.println(e.getMessage());

            return false;
        }



  }






}
