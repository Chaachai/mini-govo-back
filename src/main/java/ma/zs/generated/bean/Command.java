package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.OneToMany;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;   
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.City;
import ma.zs.generated.bean.OrderStatus;

@Entity
public class Command {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private Boolean commentResolution ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date regulationDate ;
     private BigDecimal longitudeDelivery ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date commentResolutionDate  ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date dateSubmission ;
     private Long nbrTotalComment ;
     private Long yearCommand ;
     private BigDecimal latitudeDelivery ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date orderDate ;
     private String address ;
     private String reference ;
     private Long dayCommand ;
     private Long monthCommand ;
     private String remark ;
     private BigDecimal total ;

     @ManyToOne
	private User admin ;
     @ManyToOne
	private User deliveryMan ;
     @ManyToOne
	private User client ;
     @ManyToOne
	private City city ;
     @ManyToOne
	private OrderStatus orderStatus ;
     @OneToMany(mappedBy = "command")
     private List<OrderLine> orderLines ;
     @OneToMany(mappedBy = "command")
     private List<Comment> comments ;

     public Command(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getReference(){
          return this.reference;
     }
     public void setReference(String reference){
          this.reference = reference;
     }
     public Date getOrderDate(){
          return this.orderDate;
     }
     public void setOrderDate(Date orderDate){
          this.orderDate = orderDate;
     }
     public String getAddress(){
          return this.address;
     }
     public void setAddress(String address){
          this.address = address;
     }
     public City getCity(){
          return this.city;
     }
     public void setCity(City city){
          this.city = city;
     }
     public OrderStatus getOrderStatus(){
          return this.orderStatus;
     }
     public void setOrderStatus(OrderStatus orderStatus){
          this.orderStatus = orderStatus;
     }
     public List<OrderLine> getOrderLines(){
          return this.orderLines;
     }
     public void setOrderLines(List<OrderLine> orderLines){
          this.orderLines = orderLines;
     }
     public BigDecimal getTotal(){
          return this.total;
     }
     public void setTotal(BigDecimal total){
          this.total = total;
     }
     public String getRemark(){
          return this.remark;
     }
     public void setRemark(String remark){
          this.remark = remark;
     }
     public Long getDayCommand(){
          return this.dayCommand;
     }
     public void setDayCommand(Long dayCommand){
          this.dayCommand = dayCommand;
     }
     public Long getMonthCommand(){
          return this.monthCommand;
     }
     public void setMonthCommand(Long monthCommand){
          this.monthCommand = monthCommand;
     }
     public Long getYearCommand(){
          return this.yearCommand;
     }
     public void setYearCommand(Long yearCommand){
          this.yearCommand = yearCommand;
     }
     public Date getRegulationDate(){
          return this.regulationDate;
     }
     public void setRegulationDate(Date regulationDate){
          this.regulationDate = regulationDate;
     }
     public Long getNbrTotalComment(){
          return this.nbrTotalComment;
     }
     public void setNbrTotalComment(Long nbrTotalComment){
          this.nbrTotalComment = nbrTotalComment;
     }
    public Boolean isCommentResolution(){
          return this.commentResolution;
     }
       public void setCommentResolution(Boolean commentResolution){
          this.commentResolution = commentResolution;
     }
     public Date getCommentResolutionDate (){
          return this.commentResolutionDate ;
     }
     public void setCommentResolutionDate (Date commentResolutionDate ){
          this.commentResolutionDate  = commentResolutionDate ;
     }
     public BigDecimal getLongitudeDelivery(){
          return this.longitudeDelivery;
     }
     public void setLongitudeDelivery(BigDecimal longitudeDelivery){
          this.longitudeDelivery = longitudeDelivery;
     }
     public BigDecimal getLatitudeDelivery(){
          return this.latitudeDelivery;
     }
     public void setLatitudeDelivery(BigDecimal latitudeDelivery){
          this.latitudeDelivery = latitudeDelivery;
     }
     public List<Comment> getComments(){
          return this.comments;
     }
     public void setComments(List<Comment> comments){
          this.comments = comments;
     }
     public User getClient(){
          return this.client;
     }
     public void setClient(User client){
          this.client = client;
     }
     public User getAdmin(){
          return this.admin;
     }
     public void setAdmin(User admin){
          this.admin = admin;
     }
     public User getDeliveryMan(){
          return this.deliveryMan;
     }
     public void setDeliveryMan(User deliveryMan){
          this.deliveryMan = deliveryMan;
     }
     public Date getDateSubmission(){
          return this.dateSubmission;
     }
     public void setDateSubmission(Date dateSubmission){
          this.dateSubmission = dateSubmission;
     }


    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", commentResolution=" + commentResolution +
                ", regulationDate=" + regulationDate +
                ", longitudeDelivery=" + longitudeDelivery +
                ", commentResolutionDate=" + commentResolutionDate +
                ", dateSubmission=" + dateSubmission +
                ", nbrTotalComment=" + nbrTotalComment +
                ", yearCommand=" + yearCommand +
                ", latitudeDelivery=" + latitudeDelivery +
                ", orderDate=" + orderDate +
                ", address='" + address + '\'' +
                ", reference='" + reference + '\'' +
                ", dayCommand=" + dayCommand +
                ", monthCommand=" + monthCommand +
                ", remark='" + remark + '\'' +
                ", total=" + total +
                ", admin=" + admin +
                ", deliveryMan=" + deliveryMan +
                ", client=" + client +
                ", city=" + city +
                ", orderStatus=" + orderStatus +
                ", orderLines=" + orderLines +
                ", comments=" + comments +
                '}';
    }
}

