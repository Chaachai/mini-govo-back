package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;   
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.OrderStatus;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.Command;
import ma.zs.generated.bean.Product;

@Entity
public class OrderLine {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date dateAcceptationCollaborator ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date datePreparationCollaborator ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date dateRecuperationDelivery ;
     private String rejectionReason ;
     private String description ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date dateSubmissionToCollaborator ;
     private BigDecimal longitudeCollaborator ;
     private BigDecimal latitudeCollaborator ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date dateRejectionCllaborator ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date dateRejectionDelivery ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date dateSubmissionDelivery ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date dateAcceptationDelivery ;
     private String dateDelivery ;
     private BigDecimal preparedQte ;
     private BigDecimal sentQte ;
     private BigDecimal price ;
     private BigDecimal orderedQte ;
     private BigDecimal deliveredQte;

     @ManyToOne
	private OrderStatus orderStatus  ;
     @ManyToOne
	private User deliveryMan ;
     @ManyToOne
	private User collaborator ;
     @ManyToOne
	private Command command ;
     @ManyToOne
	private Product product ;

     public OrderLine(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public BigDecimal getPrice(){
          return this.price;
     }
     public void setPrice(BigDecimal price){
          this.price = price;
     }
     public BigDecimal getOrderedQte(){
          return this.orderedQte;
     }
     public void setOrderedQte(BigDecimal orderedQte){
          this.orderedQte = orderedQte;
     }
     public BigDecimal getPreparedQte(){
          return this.preparedQte;
     }
     public void setPreparedQte(BigDecimal preparedQte){
          this.preparedQte = preparedQte;
     }
     public BigDecimal getSentQte(){
          return this.sentQte;
     }
     public void setSentQte(BigDecimal sentQte){
          this.sentQte = sentQte;
     }
     public BigDecimal getDeliveredQte(){
          return this.deliveredQte;
     }
     public void setDeliveredQte(BigDecimal deliveredQte){
          this.deliveredQte = deliveredQte;
     }
     public String getDescription(){
          return this.description;
     }
     public void setDescription(String description){
          this.description = description;
     }
     public OrderStatus getOrderStatus (){
          return this.orderStatus ;
     }
     public void setOrderStatus (OrderStatus orderStatus ){
          this.orderStatus  = orderStatus ;
     }
     public String getRejectionReason(){
          return this.rejectionReason;
     }
     public void setRejectionReason(String rejectionReason){
          this.rejectionReason = rejectionReason;
     }
     public Command getCommand(){
          return this.command;
     }
     public void setCommand(Command command){
          this.command = command;
     }
     public BigDecimal getLongitudeCollaborator(){
          return this.longitudeCollaborator;
     }
     public void setLongitudeCollaborator(BigDecimal longitudeCollaborator){
          this.longitudeCollaborator = longitudeCollaborator;
     }
     public BigDecimal getLatitudeCollaborator(){
          return this.latitudeCollaborator;
     }
     public void setLatitudeCollaborator(BigDecimal latitudeCollaborator){
          this.latitudeCollaborator = latitudeCollaborator;
     }
     public User getCollaborator(){
          return this.collaborator;
     }
     public void setCollaborator(User collaborator){
          this.collaborator = collaborator;
     }
     public User getDeliveryMan(){
          return this.deliveryMan;
     }
     public void setDeliveryMan(User deliveryMan){
          this.deliveryMan = deliveryMan;
     }
     public Date getDateSubmissionToCollaborator(){
          return this.dateSubmissionToCollaborator;
     }
     public void setDateSubmissionToCollaborator(Date dateSubmissionToCollaborator){
          this.dateSubmissionToCollaborator = dateSubmissionToCollaborator;
     }
     public Date getDateAcceptationCollaborator(){
          return this.dateAcceptationCollaborator;
     }
     public void setDateAcceptationCollaborator(Date dateAcceptationCollaborator){
          this.dateAcceptationCollaborator = dateAcceptationCollaborator;
     }
     public Date getDatePreparationCollaborator(){
          return this.datePreparationCollaborator;
     }
     public void setDatePreparationCollaborator(Date datePreparationCollaborator){
          this.datePreparationCollaborator = datePreparationCollaborator;
     }
     public Date getDateRecuperationDelivery(){
          return this.dateRecuperationDelivery;
     }
     public void setDateRecuperationDelivery(Date dateRecuperationDelivery){
          this.dateRecuperationDelivery = dateRecuperationDelivery;
     }
     public String getDateDelivery(){
          return this.dateDelivery;
     }
     public void setDateDelivery(String dateDelivery){
          this.dateDelivery = dateDelivery;
     }
     public Date getDateSubmissionDelivery(){
          return this.dateSubmissionDelivery;
     }
     public void setDateSubmissionDelivery(Date dateSubmissionDelivery){
          this.dateSubmissionDelivery = dateSubmissionDelivery;
     }
     public Date getDateAcceptationDelivery(){
          return this.dateAcceptationDelivery;
     }
     public void setDateAcceptationDelivery(Date dateAcceptationDelivery){
          this.dateAcceptationDelivery = dateAcceptationDelivery;
     }
     public Date getDateRejectionCllaborator(){
          return this.dateRejectionCllaborator;
     }
     public void setDateRejectionCllaborator(Date dateRejectionCllaborator){
          this.dateRejectionCllaborator = dateRejectionCllaborator;
     }
     public Date getDateRejectionDelivery(){
          return this.dateRejectionDelivery;
     }
     public void setDateRejectionDelivery(Date dateRejectionDelivery){
          this.dateRejectionDelivery = dateRejectionDelivery;
     }
     public Product getProduct(){
          return this.product;
     }
     public void setProduct(Product product){
          this.product = product;
     }



}

