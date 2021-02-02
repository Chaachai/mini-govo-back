package ma.zs.generated.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     private String email;
     private String password;
     @JsonFormat(pattern = "yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date created;
     @ManyToOne
     private Role authority;
     private String firstName;
     private String lastName;
     private String code;
     private String phoneNumber;
     private String address;
     @ManyToOne
     private City city;
     private Double longitude;
     private Double latitude;
     private Boolean enabled;
     private Boolean enabledNewCommand = false;
     @OneToMany(mappedBy = "collaborator")
     private List<SpecialiteCollaborator> specialityCollaborators;
     @OneToMany(mappedBy = "collaborator")
     private List<PricingCollaborator> pricingCollaborators;
     @OneToMany(mappedBy = "collaborator")
     private List<Rating> ratings;
     @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
     private List<Command> commands;


     public User(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public Date getCreated() {
          return created;
     }

     public void setCreated(Date created) {
          this.created = created;
     }

     public Role getAuthority() {
          return authority;
     }

     public void setAuthority(Role authority) {
          this.authority = authority;
     }

     public String getFirstName() {
          return firstName;
     }

     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }

     public String getLastName() {
          return lastName;
     }

     public void setLastName(String lastName) {
          this.lastName = lastName;
     }

     public String getCode() {
          return code;
     }

     public void setCode(String code) {
          this.code = code;
     }

     public String getPhoneNumber() {
          return phoneNumber;
     }

     public void setPhoneNumber(String phoneNumber) {
          this.phoneNumber = phoneNumber;
     }

     public String getAddress() {
          return address;
     }

     public void setAddress(String address) {
          this.address = address;
     }

     public City getCity() {
          return city;
     }

     public void setCity(City city) {
          this.city = city;
     }

     public Double getLongitude() {
          return longitude;
     }

     public void setLongitude(Double longitude) {
          this.longitude = longitude;
     }

     public Double getLatitude() {
          return latitude;
     }

     public void setLatitude(Double latitude) {
          this.latitude = latitude;
     }

     public Boolean getEnabled() {
          return enabled;
     }

     public void setEnabled(Boolean enabled) {
          this.enabled = enabled;
     }

     public Boolean getEnabledNewCommand() {
          return enabledNewCommand;
     }

     public void setEnabledNewCommand(Boolean enabledNewCommand) {
          this.enabledNewCommand = enabledNewCommand;
     }

     public List<SpecialiteCollaborator> getSpecialityCollaborators() {
          return specialityCollaborators;
     }

     public void setSpecialityCollaborators(List<SpecialiteCollaborator> specialityCollaborators) {
          this.specialityCollaborators = specialityCollaborators;
     }

     public List<Rating> getRatings() {
          return ratings;
     }

     public void setRatings(List<Rating> ratings) {
          this.ratings = ratings;
     }

     public List<Command> getCommands() {
          return commands;
     }

     public void setCommands(List<Command> commands) {
          this.commands = commands;
     }

     public List<PricingCollaborator> getPricingCollaborators() {
          return pricingCollaborators;
     }

     public void setPricingCollaborators(List<PricingCollaborator> pricingCollaborators) {
          this.pricingCollaborators = pricingCollaborators;
     }
}

