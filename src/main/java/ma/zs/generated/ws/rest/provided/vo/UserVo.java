package ma.zs.generated.ws.rest.provided.vo;


import ma.zs.generated.bean.*;

import java.util.Date;
import java.util.List;

public class UserVo {

    private String id;
    private String email;
    private String password;
    private String createdDate;
    private RoleVo roleVo;
    private String firstName;
    private String lastName;
    private String code;
    private String phoneNumber;
    private String address;

    private CityVo cityVo;
    private String longitude;
    private String latitude;
    private String enabled;
    private String enabledNewCommand;
    private List<SpecialiteCollaboratorVo> specialityCollaboratorsVos;
    private List<PricingCollaboratorVo> pricingCollaboratorsVos;
    private List<RatingVo> ratingVos;
    private List<CommandVo> commandVos;

    private String rating;

    public UserVo() {
        super();
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public RoleVo getRoleVo() {
        return roleVo;
    }

    public void setRoleVo(RoleVo roleVo) {
        this.roleVo = roleVo;
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

    public CityVo getCityVo() {
        return cityVo;
    }

    public void setCityVo(CityVo cityVo) {
        this.cityVo = cityVo;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getEnabledNewCommand() {
        return enabledNewCommand;
    }

    public void setEnabledNewCommand(String enabledNewCommand) {
        this.enabledNewCommand = enabledNewCommand;
    }

    public List<SpecialiteCollaboratorVo> getSpecialityCollaboratorsVos() {
        return specialityCollaboratorsVos;
    }

    public void setSpecialityCollaboratorsVos(List<SpecialiteCollaboratorVo> specialityCollaboratorsVos) {
        this.specialityCollaboratorsVos = specialityCollaboratorsVos;
    }

    public List<RatingVo> getRatingVos() {
        return ratingVos;
    }

    public void setRatingVos(List<RatingVo> ratingVos) {
        this.ratingVos = ratingVos;
    }

    public List<CommandVo> getCommandVos() {
        return commandVos;
    }

    public void setCommandVos(List<CommandVo> commandVos) {
        this.commandVos = commandVos;
    }

    public List<PricingCollaboratorVo> getPricingCollaboratorsVos() {
        return pricingCollaboratorsVos;
    }

    public void setPricingCollaboratorsVos(List<PricingCollaboratorVo> pricingCollaboratorsVos) {
        this.pricingCollaboratorsVos = pricingCollaboratorsVos;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}