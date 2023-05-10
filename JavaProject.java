/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.FileInputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.effect.*;

/**
 *
 * @author nadia
 */

public class JavaProject extends Application {
    
    Label title, retlbl, isslbl, lblus, lblissd;
    Label lfname, llname, ldob, lPhone,lgen,lem,ladd,uid,searchlbl,bks,bid,id,date,llid,pass,lbldued,bkid,rlpss,usid,rlid;
    TextField  tfname, tlname, tdob, tPhone,tadd, tem,tsearch,tbid,tid,tdate,tlid,tpass,tbkid,rtlid,tusid,rtlpss;
    Stage window;
    Scene schome, scissue, screturn, screg, screport ;
    ToggleGroup tgen; 
    RadioButton bmale, bfemale; 
    Button bregHome, bregister, bsearch,biss, brep;
    @Override
    public void start (Stage primaryStage) throws Exception{
        
        window= primaryStage;
        window= primaryStage;
        GridPane h = new GridPane();
        h.setId("home");
        h.setHgap(10);
        h.setVgap(5);
        h.setBorder(Border.EMPTY);
        h.setPadding(Insets.EMPTY);
        h.getStylesheets().add("javaproject/Styles.css");  
        primaryStage.setTitle("Java Project");
        title=new Label("LIBRARY HOME PAGE");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 60px;");
        //home
        Button breg=new Button("User Registeration");
        breg.setPadding(Insets.EMPTY);
        breg.setPrefSize(500,150);
        breg.setStyle("-fx-border-color: #000; -fx-border-width: 5px;");
        
        Button bissue=new Button("Issue");
        bissue.setPrefSize(250,150);
        bissue.setStyle("-fx-border-color: #000; -fx-border-width: 5px;");

        
        Button breturn=new Button("Return");
        breturn.setPrefSize(250,150);
        breturn.setStyle("-fx-border-color: #000; -fx-border-width: 5px;");

        
        Button brep=new Button("Report");
        brep.setPrefSize(250,150);
        brep.setStyle("-fx-border-color: #000; -fx-border-width: 5px;");
        
        searchlbl= new Label("Search for a bo");
        searchlbl.setStyle("color:white;");
        tsearch=new TextField();
        tsearch.setText("Seacrh a Book");
        bsearch=new Button("Search");
        bks= new Label();
        bks.setStyle("-fx-text-fill: white; -fx-font-size: 50px;");
        h.add(title, 2, 1);
        h.add(breg, 2, 3);
        h.add(bissue, 2, 4);
        h.add(breturn, 2,5);
        h.add(brep, 2,6);
        h.add(tsearch,2,8);
        h.add(bsearch,3,8);
        h.add(bks,2,9);

        schome = new Scene(h,1000,1000);
        h.getStylesheets().add("javaproject/Styles.css"); 
        
          breg.setOnAction(e -> window.setScene(screg));
        bissue.setOnAction(e -> window.setScene(scissue));
        breturn.setOnAction(e -> window.setScene(screturn));
        brep.setOnAction(e -> window.setScene(screport));
        bsearch.setOnAction(e -> displayBooks());
        //bhome.setOnAction(e -> window.setScene(schome));
        
        //registration
        Label lreg= new Label("User Registration");
        Line l1= new Line();
        l1.setStartX(50);
        l1.setStartY(2);
        l1.setEndX(800);
        l1.setEndY(2);
        lfname= new Label("First Name:");
        tfname=new TextField();  
        llname= new Label("Last Name:");
        tlname=new TextField();  
        ldob= new Label("DOB:");
        tdob=new TextField();  
        lPhone= new Label("Phone:");
        tPhone=new TextField();  
        lem= new Label("Email:");
        tem=new TextField();  
        ladd= new Label("Address:");
        tadd=new TextField();  
         tgen = new ToggleGroup(); 
         lgen=new Label("Gender:");
         uid=new Label();
     bmale = new RadioButton("Male");  
     bfemale = new RadioButton("Female");  
    bmale.setToggleGroup(tgen);  
    bfemale.setToggleGroup(tgen);
     bregHome= new Button("Home");
     bregister = new Button("REGISTER");
    bregister.setOnAction(e->insertUser());
    
    Image imgrg = new Image(new FileInputStream("C:\\Users\\nadia\\OneDrive\\Pictures\\reg.jpg"));  
      ImageView imgVrg = new ImageView(imgrg); 
      imgVrg.setX(50); 
      imgVrg.setY(25); 
      imgVrg.setFitHeight(400); 
      imgVrg.setFitWidth(550); 
      imgVrg.setPreserveRatio(true);  
    GridPane regpg= new GridPane();
    regpg.setId("registerpg");
    regpg.setHgap(5);
    regpg.setVgap(10);
    regpg.add(lreg,1,1);
    regpg.add(l1,2,2);
    regpg.add( lfname,1,3);
    regpg.add(tfname,2,3);
    regpg.add( llname,1,4);
    regpg.add(tlname,2,4);
    regpg.add( ldob,1,5);
    regpg.add(tdob,2,5);
    regpg.add(lPhone,1,6);
    regpg.add( tPhone,2,6);
    regpg.add(ladd,1,7);
    regpg.add( tadd,2,7);
    regpg.add( lem,1,8);
    regpg.add( tem,2,8);
    regpg.add( lgen,1,9);
    regpg.add( bmale,2,9);
    regpg.add( bfemale,2,10);
    regpg.add( bregHome,1,0);
    regpg.add( bregister,2,11);
    regpg.add( uid,1,11);
    regpg.add( imgVrg,2,12);
    regpg.getStylesheets().add("javaproject/Styles.css");  
    
    bregHome.setOnAction(e -> window.setScene(schome));
    bsearch.setOnAction(e->displayBooks());
    
        //regpg.getChildren().addAll(bhome, bissue, breturn,lname, tname, lage, tage, lPhone, tPhone, lAddress, tAddress, lgen, bmale, bfemale);
        screg = new Scene(regpg,1000,1000);
        
        //issue page
        Label biss= new Label("Issue a Book");
        Line isl= new Line();
        isl.setStartX(20);
        isl.setStartY(2);
        isl.setEndX(400);
        isl.setEndY(2);
        isl.setFill(Color.BLUE);
        llid= new Label("Librarian ID:");
        tlid=new TextField();  
        bid= new Label("Book ID :");
        tbid=new TextField();  
        id= new Label("User ID:");
        tid=new TextField();  
        pass= new Label("Librarian Password:");
        tpass=new TextField();  
        lbldued= new Label();
        Image image = new Image(new FileInputStream("C:\\Users\\nadia\\OneDrive\\Pictures\\issue.jpg"));  
      ImageView imageView = new ImageView(image); 
      imageView.setX(50); 
      imageView.setY(25); 
      imageView.setFitHeight(455); 
      imageView.setFitWidth(500); 
      imageView.setPreserveRatio(true);  
        
       
    Button bissHome= new Button("Home");
    Button bkissue = new Button("ISSUE A BOOK");
    Reflection gl=new Reflection();
    bkissue.setEffect(gl);
    //bkissue.setOnAction(e->display());
    
    GridPane isspg= new GridPane();
    isspg.setId("issuepg");
    isspg.setHgap(5);
    isspg.setVgap(10);
    isspg.add(bissHome,1,1);
    isspg.add(biss,1,2);
    isspg.add( isl,1,3);
    isspg.add( llid,1,4);
    isspg.add(tlid,2,4);
    isspg.add(pass,1,5);
    isspg.add( tpass,2,5);
    isspg.add( bid,1,7);
    isspg.add(tbid,2,7);
    isspg.add( id,1,6);
    isspg.add(tid,2,6);
    isspg.add(bkissue,2,10);
        isspg.add(lbldued,1,12);
        isspg.add(imageView,2,14);

     scissue = new Scene(isspg,1000,1000);
     isspg.getStylesheets().add("javaproject/Styles.css");  
  
    
    bissue.setOnAction(e -> window.setScene(scissue));
    bissHome.setOnAction(e -> window.setScene(schome));
    bkissue.setOnAction(e->issueBook());
    
    //return page
    
        Label bret= new Label("Return a Book");
        Line r= new Line();
        r.setStartX(20);
        r.setStartY(2);
        r.setEndX(400);
        r.setEndY(2);
        
        bkid= new Label("Book ID :");
        tbkid=new TextField();  
        rlid= new Label("Librarian ID:");
        rtlid=new TextField(); 
        usid= new Label("User ID:");
        tusid=new TextField();  
        rlpss= new Label("Librarian password:");
        rtlpss=new TextField();  
        retlbl=new Label();
         
        
       
    Button bretHome= new Button("Home");
    Button bkreturn = new Button("Return a Book");
    Reflection ca=new Reflection();
    bkreturn.setEffect(ca);
    //bkissue.setOnAction(e->display());
    
    GridPane retpg= new GridPane();
    Image imgrt = new Image(new FileInputStream("C:\\Users\\nadia\\OneDrive\\Pictures\\return.jpg"));  
      ImageView imgVrt = new ImageView(imgrt); 
      imgVrt.setX(50); 
      imgVrt.setY(25); 
      imgVrt.setFitHeight(400); 
      imgVrt.setFitWidth(500); 
      imgVrt.setPreserveRatio(true);  
    retpg.setId("returnpg");
    retpg.setHgap(5);
    retpg.setVgap(10);
    retpg.add(bretHome,1,1);
    retpg.add(bret,1,2);
    retpg.add( r,1,3);
    retpg.add( bkid,1,4);
    retpg.add(tbkid,2,4);
    retpg.add(rlid,1,6);
    retpg.add( rtlid,2,6);
    retpg.add( usid,1,5);
    retpg.add(tusid,2,5);
    retpg.add( rlpss,1,7);
    retpg.add(rtlpss,2,7);
    retpg.add(bkreturn,2,10);
    retpg.add(retlbl,1,12);
    retpg.add(imgVrt,2,13);
        

     screturn = new Scene(retpg,1000,1000);
     retpg.getStylesheets().add("javaproject/Styles.css");  
     
     //report page
     GridPane reppg= new GridPane();
     Image imgrp = new Image(new FileInputStream("C:\\Users\\nadia\\OneDrive\\Pictures\\bk2.jpg"));  
      ImageView imgVrp = new ImageView(imgrp); 
      imgVrp.setStyle("-fx-border-color: #000; -fx-border-width: 5px;");
      imgVrp.setX(50); 
      imgVrp.setY(25); 
      imgVrp.setFitHeight(455); 
      imgVrp.setFitWidth(500); 
      imgVrp.setPreserveRatio(true);  
     Label lrep= new Label("Report");
        Line l1l= new Line();
        l1l.setStartX(50);
        l1l.setStartY(2);
        l1l.setEndX(800);
        l1l.setEndY(2);
     reppg.setId("reportpg");
     lblus= new Label("");
     lblissd= new Label("");
     Button brepHome= new Button("Home");
     Button repbtn=new Button("Generate Report");
     Reflection rf=new Reflection();
     imgVrp.setEffect(rf);
     Reflection sh=new Reflection();
     //sh.setColor(Color.AQUA);
     repbtn.setEffect(sh);
     rf.setBottomOpacity(0.5);
     reppg.setHgap(5);
    reppg.setVgap(10);
    reppg.add(brepHome,1,1);
    reppg.add(repbtn,1,2);
    reppg.add(lrep,1,3);
    reppg.add(lblus,2,5);
    reppg.add( lblissd,2,7);  
    reppg.add( imgVrp,2,9);  
  
    screport = new Scene(reppg,1000,1000);
     reppg.getStylesheets().add("javaproject/Styles.css");  
     repbtn.setOnAction(e -> displayReport());
     
     
    breturn.setOnAction(e -> window.setScene(screturn));
    bissHome.setOnAction(e -> window.setScene(schome));
    bkreturn.setOnAction(e->returnBook());
    bretHome.setOnAction(e -> window.setScene(schome));
    brepHome.setOnAction(e -> window.setScene(schome));
    brep.setOnAction(e -> window.setScene(screport));
        
        
        primaryStage.setScene(schome);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public void insertUser() {
            //Class.forName("com.mysql.jdbc.Driver");
        
            String url="jdbc:mysql://localhost:3306/librarys";
        String uname="root";
        String pass="";
        try{
            
         //ConnectionClass conCl=new ConnectionClass();
         //Connection con=conCl.getConnection();
         Connection con=DriverManager.getConnection(url,uname,pass);
            //Statement stmt=con.createStatement();
            System.out.println("connected");
            String sql = "INSERT INTO `user`(`Fname`, `Lname`, `DOB`, `gender`, `email`, `ph_no`, `address`, `reg_date`) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement stmt=con.prepareStatement(sql);
            String fn=tfname.getText();
            String ln=tlname.getText();
            String dob=tdob.getText();
            Date dt=new Date();
        SimpleDateFormat fd=new SimpleDateFormat("yyyy-MM-dd");
            stmt.setString(1, fn);
            stmt.setString(2, ln);
            stmt.setString(3, dob);
            if(bmale.isSelected()){
                stmt.setString(4, "M");
            }
            else{
                stmt.setString(4, "F");
            }
            stmt.setString(5, tem.getText());
            stmt.setString(6, tPhone.getText());
           stmt.setString(7, tadd.getText());
           stmt.setString(8, fd.format(dt));
           int i=stmt.executeUpdate();
           if(i>0){
               System.out.println("Inserted");
               String sql2="Select U_id from `user` where Fname='"+fn+"' and dob='"+dob+"';";
               Statement st=con.createStatement();
               ResultSet rs=st.executeQuery(sql2);
               while(rs.next()){
                   uid.setText("Uid is "+rs.getString("U_id"));
               }
           }
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
    public void issueBook(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/librarys";
        String uname="root";
        String pass="";
        LocalDate dt = LocalDate.now();
            Connection con=DriverManager.getConnection(url,uname,pass);
            Statement st=con.createStatement();
             System.out.println("connected");
            String sql1 = "select * from librarian where L_id='"+tlid.getText()+"';";
            System.out.println(sql1);
            ResultSet rs=st.executeQuery(sql1);
               while(rs.next()){
                   System.out.println("pass correct "+rs.getString("passwd"));
                   if(rs.getString("passwd").compareTo(tpass.getText())==0){
                       String sql = "INSERT INTO `issues`(`U_id`, `B_id`, `L_id`, `stat`, `borrow_date`, `due_date`) VALUES (?,?,?,?,?,?);";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, tid.getText());
            stmt.setString(2, tbid.getText());
            stmt.setString(3, tlid.getText());
            stmt.setString(4, "borrowed");
            stmt.setString(5, dt.toString());
            stmt.setString(6, dt.plusMonths(1).toString());
                       System.out.println(sql+dt);
           try{
                       int i = stmt.executeUpdate();
                       if(i>0){
               System.out.println("Inserted");
               lbldued.setText("Book issued\n The due date is : "+dt.plusMonths(1).toString());
           }
           }
           catch(Exception e){
               System.out.println(e);
           }
                   }
               }
        }
        catch(Exception e){
            
        }
    }
    public void returnBook(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/librarys";
        String uname="root";
        String pass="";
            Connection con=DriverManager.getConnection(url,uname,pass);
            //Statement stmt=con.createStatement();
             //LocalDate dt = LocalDate.now();
            LocalDate dt = LocalDate.now();
            System.out.println("connected");
            String sql = "UPDATE issues set `stat`='returned', `return_date`=? WHERE `U_id`=?  AND `B_id`=?;";
            PreparedStatement stmt=con.prepareStatement(sql);
            //Date dt=new Date();
           SimpleDateFormat fd=new SimpleDateFormat("yyyy-MM-dd");
            stmt.setString(1,dt.toString());
            stmt.setString(2, tusid.getText());
            stmt.setString(3, tbkid.getText());
           int i=stmt.executeUpdate();
           if(i>0){
               System.out.println("Returned");
               retlbl.setText("Book Returned");
           }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void displayBooks() {
            //Class.forName("com.mysql.jdbc.Driver");
        
            String url="jdbc:mysql://localhost:3306/librarys";
        String uname="root";
        String pass="";
        String bnm = tsearch.getText();
        System.out.println(tsearch);
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con=DriverManager.getConnection(url,uname,pass);
            //Statement stmt=con.createStatement();
            System.out.println("connected");
            String sql = "select * from book where Bname like '%"+bnm+"%';";
            Statement stmt=con.createStatement();
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            
            String bk="Bid\t Name\t\t Author\n";
            while(rs.next()){
                bk+=rs.getString("B_id");
                bk+="\t";
                bk+=rs.getString("Bname");
                bk+="\t";
                bk+=rs.getString("author");
                bk+= "\n";
                System.out.println(bk);
            }
            bks.setBorder(Border.EMPTY);
            
            bks.setText(bk);
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
    public void displayReport() {
            //Class.forName("com.mysql.jdbc.Driver");
        
            String url="jdbc:mysql://localhost:3306/librarys";
        String uname="root";
        String pass="";
        String users="The number of registered users are: ";
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
         Connection con=DriverManager.getConnection(url,uname,pass);
            //Statement stmt=con.createStatement();
            System.out.println("connected");
            String sql = "select count(*) from user";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                users+=rs.getString("count(*)");
            }
            lblus.setText(users);
            String sql2 = "select * from issues where stat='borrowed';";
            Statement stmt2=con.createStatement();
            ResultSet rs2=stmt.executeQuery(sql2);
            String issues="List of currently issued books\n User ID\t\t Book ID\t\t Due Date\n";
            while(rs2.next()){
                issues+=rs2.getString("U_id");
                issues+= " \t\t";
                issues+=rs2.getString("B_id");
                issues+= "                    ";
                issues+=rs2.getString("due_date");
                issues+= "\n";
            }
            lblissd.setText(issues);
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
    public static void main(String[] args) {
        launch(args);
        
    }
    }