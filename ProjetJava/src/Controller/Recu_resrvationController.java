/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import entite.Car;
import entite.user;
import entite.Car_reservation;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import com.itextpdf.text.*;
import service.CarService;
import service.UserService;
import service.ReservationCarService;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.scenario.effect.ImageData;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;

import javax.imageio.ImageIO;
 
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.geometry.BoundingBox;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javax.swing.JFrame;

/**
 * FXML Controller class
 *
 * @author chihe
 */
public class Recu_resrvationController implements Initializable {

    @FXML
    private Label date_aj;
    @FXML
    private Label id_reservation;
    @FXML
    private Label c_b;
    @FXML
    private Label c_m;
    @FXML
    private Label km_c;
    @FXML
    private Label f_n_u;
    @FXML
    private Label l_n_u;
    @FXML
    private ImageView imgr;
    @FXML
    private Button PDF;
    @FXML
    private Label uprice;
    @FXML
    private Label sdate;
    @FXML
    private Label sdate1;
    @FXML
    private Label amount;
    @FXML
    private Label discount;
    @FXML
    private Label tva;
    @FXML
    private Label total;
    @FXML
    private Button PRINT;
  private JFrame frame;
    private BoundingBox boundbox;
    private Timer timer;
    private Stage stage;
    private Scene scene;
    @FXML
    private StackPane stack;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     LocalDate now = LocalDate.now(); 
           date_aj.setText(String.valueOf(now));
           
           
            
    }    

    public void setDate_aj(Label date_aj) {
        this.date_aj = date_aj;
    }

    public void setId_reservation(String id_reservation) {
        this.id_reservation.setText(id_reservation);
        
    }

    public void setC_b(String c_b) {
        this.c_b.setText(c_b);
    }

    public void setC_m(String c_m) {
        this.c_m.setText(c_m);
    }

    public void setKm_c(String km_c) {
        this.km_c.setText(km_c);
    }

    public void setF_n_u(String f_n_u) {
        this.f_n_u.setText(f_n_u);
    }

    public void setL_n_u(String l_n_u) {
        this.l_n_u.setText(l_n_u);
    }

    public void setImgr(ImageView imgr) {
        this.imgr.setImage(imgr.getImage());
    }

    public void setUprice(String uprice) {
        this.uprice.setText(uprice);
    }

    public void setSdate(String sdate) {
        this.sdate.setText(sdate);
    }

    public void setSdate1(String sdate1) {
        this.sdate1.setText(sdate1);
    }

    public void setAmount(String amount) {
        this.amount.setText(amount);
    }

    public void setDiscount(Label discount) {
        this.discount = discount;
    }

    public void setTva(String tva) {
        this.tva.setText(tva);
    }

    public void setTotal(String total) {
        this.total.setText(total) ;
        
    }
    private void Image(){
        WritableImage writableImage = new WritableImage(1315, 810);

    // Capture d'écran
     SnapshotParameters snapShotparams = new SnapshotParameters();
    stack.snapshot(snapShotparams, writableImage);

    // Le fichier où enregistrer l'image
    File imageFile = new File("C:\\Users\\meria\\Downloads\\screenshotapp.png");

    // Conversion d'une image JavaFX vers BufferedImage
    BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);
    

    try {
      // Enregistrement de l'image dans le fichier
      ImageIO.write(bufferedImage, "png", imageFile);
    } catch (Exception e) {
      e.printStackTrace();
    }

    stage.setScene(scene);
    stage.show();
    }

    @FXML
    private void PRINT(ActionEvent event) throws IOException, InterruptedException {
      

    // La scène à capturer

//    // L'image avec sa taille (taille de la scène)


//    Image();
    

  

 


     String FILE_NAME = "C:\\Users\\meria\\Downloads\\t.pdf";
     Document doc = new Document(PageSize.A4_LANDSCAPE,10,10,10,10);
     try {
        
                     PdfWriter.getInstance(doc, new FileOutputStream(new File(FILE_NAME)));

     doc.open();
     Paragraph p = new Paragraph();
            p.add("Car Reservation Invoice");
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            

       Image img = 
       Image.getInstance("C:\\Users\\meria\\Downloads\\screenshotapp.png");
       img.scaleToFit(590, 800);
 
     doc.add(img);
         
      
   
       doc.close();
         Desktop.getDesktop().open( new File ("C:\\Users\\meria\\Downloads\\t.pdf"));
     
       }catch(DocumentException e){
           e.printStackTrace();
       }

    }
 

    private OutputStream FileOutputStream(String cUserschiheOneDriveBureauCarMarkettpdf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    
//


    

 }

    @FXML
    private void imgg(ActionEvent event) {
        Image();
    }

    }
    
