package ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;


import ma.zs.generated.bean.User;
import ma.zs.generated.ws.rest.provided.vo.UserVo;

@Component
public class UserConverter extends AbstractConverter<User, UserVo> {
    private Boolean role = false;
    private Boolean city= false;
    private Boolean specialityCollaborators= false;
    private Boolean ratings= false;
    private Boolean commands= false;

    @Autowired
    private RoleConverter roleConverter;
    @Autowired
    private CityConverter cityConverter;
    @Autowired
    private SpecialiteCollaboratorConverter specialiteCollaboratorConverter;
    @Autowired
    private RatingConverter ratingConverter;
    @Autowired
    private CommandConverter commandConverter;

    public UserConverter() {
        init(true);
    }

    @Override
    public User toItem(UserVo vo) {
        if (vo == null) {
            return null;
        } else {
            User item = new User();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getEmail()))
                item.setEmail(vo.getEmail());
            if (StringUtil.isNotEmpty(vo.getPassword()))
                item.setPassword(vo.getPassword());
            if (StringUtil.isNotEmpty(vo.getCreatedDate()))
                item.setCreated(DateUtil.parse(vo.getCreatedDate()));
            if (vo.getRoleVo() != null
                    && role)
                item.setAuthority(roleConverter.toItem(vo.getRoleVo()));
            if (StringUtil.isNotEmpty(vo.getFirstName()))
                item.setFirstName(vo.getFirstName());
            if (StringUtil.isNotEmpty(vo.getLastName()))
                item.setLastName(vo.getLastName());
            if (StringUtil.isNotEmpty(vo.getCode()))
                item.setCode(vo.getCode());
            if (StringUtil.isNotEmpty(vo.getPhoneNumber()))
                item.setPhoneNumber(vo.getPhoneNumber());
            if (StringUtil.isNotEmpty(vo.getAddress()))
                item.setAddress(vo.getAddress());
            if (vo.getCityVo() != null && this.city)
                item.setCity(cityConverter.toItem(vo.getCityVo()));
            if (StringUtil.isNotEmpty(vo.getLongitude()))
                item.setLongitude(NumberUtil.toDouble(vo.getLongitude()));
            if (StringUtil.isNotEmpty(vo.getLatitude()))
                item.setLatitude(NumberUtil.toDouble(vo.getLatitude()));
            if (StringUtil.isNotEmpty(vo.getEnabled()))
                item.setEnabled(NumberUtil.toBoolean(vo.getEnabled()));
            if (StringUtil.isNotEmpty(vo.getEnabledNewCommand()))
                item.setEnabledNewCommand(NumberUtil.toBoolean(vo.getEnabledNewCommand()));
            if (vo.getSpecialityCollaboratorsVos() != null && this.specialityCollaborators)
                item.setSpecialityCollaborators(specialiteCollaboratorConverter.toItem(vo.getSpecialityCollaboratorsVos()));
            if (vo.getRatingVos() != null && this.specialityCollaborators)
                item.setRatings(ratingConverter.toItem(vo.getRatingVos()));
            if (vo.getCommandVos() != null && this.specialityCollaborators)
                item.setCommands(commandConverter.toItem(vo.getCommandVos()));

            return item;
        }
    }

    @Override
    public UserVo toVo(User item) {
        if (item == null) {
            return null;
        } else {
            UserVo vo = new UserVo();

            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));
            if (item.getEmail() != null)
                vo.setEmail(item.getEmail());
            if (item.getPassword() != null)
                vo.setPassword(item.getPassword());
            if (item.getCreated() != null)
                vo.setCreatedDate(DateUtil.formateDate(item.getCreated()));
            if (item.getAuthority() != null && role)
                vo.setRoleVo(roleConverter.toVo(item.getAuthority()));
            if (item.getFirstName() != null)
                vo.setFirstName(item.getFirstName());
            if (item.getLastName() != null)
                vo.setLastName(item.getLastName());
            if (item.getCode() != null)
                vo.setCode(item.getCode());
            if (item.getPhoneNumber() != null)
                vo.setPhoneNumber(item.getPhoneNumber());
            if (item.getAddress() != null)
                vo.setAddress(item.getAddress());
            if (item.getCity() != null && city)
                vo.setCityVo(cityConverter.toVo(item.getCity()));
            if (item.getLongitude() != null)
                vo.setLongitude(NumberUtil.toString(item.getLongitude()));
            if (item.getLatitude() != null)
                vo.setLatitude(NumberUtil.toString(item.getLatitude()));
            if (item.getEnabled() != null)
                vo.setEnabled(NumberUtil.toString(item.getEnabled()));
            if (item.getEnabledNewCommand() != null)
                vo.setEnabledNewCommand(NumberUtil.toString(item.getEnabledNewCommand()));
            if (item.getSpecialityCollaborators() != null && specialityCollaborators)
                vo.setSpecialityCollaboratorsVos(specialiteCollaboratorConverter.toVo(item.getSpecialityCollaborators()));
            if (item.getRatings() != null && specialityCollaborators)
                vo.setRatingVos(ratingConverter.toVo(item.getRatings()));
//            if (item.getCommands() != null && specialityCollaborators)
//                vo.setCommandVos(commandConverter.toVo(item.getCommands()));
            return vo;

        }
    }

    public void init(Boolean value) {
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public Boolean getCity() {
        return city;
    }

    public void setCity(Boolean city) {
        this.city = city;
    }

    public Boolean getSpecialityCollaborators() {
        return specialityCollaborators;
    }

    public void setSpecialityCollaborators(Boolean specialityCollaborators) {
        this.specialityCollaborators = specialityCollaborators;
    }

    public Boolean getRatings() {
        return ratings;
    }

    public void setRatings(Boolean ratings) {
        this.ratings = ratings;
    }

    public Boolean getCommands() {
        return commands;
    }

    public void setCommands(Boolean commands) {
        this.commands = commands;
    }

    public RoleConverter getRoleConverter() {
        return roleConverter;
    }

    public void setRoleConverter(RoleConverter roleConverter) {
        this.roleConverter = roleConverter;
    }

    public CityConverter getCityConverter() {
        return cityConverter;
    }

    public void setCityConverter(CityConverter cityConverter) {
        this.cityConverter = cityConverter;
    }

    public SpecialiteCollaboratorConverter getSpecialiteCollaboratorConverter() {
        return specialiteCollaboratorConverter;
    }

    public void setSpecialiteCollaboratorConverter(SpecialiteCollaboratorConverter specialiteCollaboratorConverter) {
        this.specialiteCollaboratorConverter = specialiteCollaboratorConverter;
    }

    public RatingConverter getRatingConverter() {
        return ratingConverter;
    }

    public void setRatingConverter(RatingConverter ratingConverter) {
        this.ratingConverter = ratingConverter;
    }

    public CommandConverter getCommandConverter() {
        return commandConverter;
    }

    public void setCommandConverter(CommandConverter commandConverter) {
        this.commandConverter = commandConverter;
    }
}