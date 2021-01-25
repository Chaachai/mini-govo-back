package ma.zs.generated.ws.rest.provided.converter;

import ma.zs.generated.bean.CategoryProduit;
import ma.zs.generated.bean.PricingCollaborator;
import ma.zs.generated.bean.SpecialiteCollaborator;
import ma.zs.generated.service.util.NumberUtil;
import ma.zs.generated.service.util.StringUtil;
import ma.zs.generated.ws.rest.provided.vo.PricingCollaboratorVo;
import ma.zs.generated.ws.rest.provided.vo.SpecialiteCollaboratorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecialiteCollaboratorConverter extends AbstractConverter<SpecialiteCollaborator, SpecialiteCollaboratorVo> {
    private Boolean categoryProduit;
    private Boolean collaborator;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private CategoryProduitConverter categoryProduitConverter;

    public SpecialiteCollaboratorConverter() {
        init(true);
    }

    @Override
    public SpecialiteCollaborator toItem(SpecialiteCollaboratorVo vo) {
        if (vo == null) {
            return null;
        } else {
            SpecialiteCollaborator item = new SpecialiteCollaborator();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (vo.getCategoryProduitVo() != null && this.categoryProduit)
                item.setCategoryProduit(categoryProduitConverter.toItem(vo.getCategoryProduitVo()));
            if (vo.getCollaboratorVo() != null && this.collaborator)
                item.setCollaborator(userConverter.toItem(vo.getCollaboratorVo()));

            return item;
        }
    }

    @Override
    public SpecialiteCollaboratorVo toVo(SpecialiteCollaborator item) {
        if (item == null) {
            return null;
        } else {
            SpecialiteCollaboratorVo vo = new SpecialiteCollaboratorVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));
            if (item.getCategoryProduit() != null && this.categoryProduit)
                vo.setCategoryProduitVo(categoryProduitConverter.toVo(item.getCategoryProduit()));
            if (item.getCollaborator() != null && this.collaborator)
                vo.setCollaboratorVo(userConverter.toVo(item.getCollaborator()));


            return vo;

        }
    }

    public void init(Boolean value) {
    }

    public Boolean getCategoryProduit() {
        return categoryProduit;
    }

    public void setCategoryProduit(Boolean categoryProduit) {
        this.categoryProduit = categoryProduit;
    }

    public Boolean getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(Boolean collaborator) {
        this.collaborator = collaborator;
    }

    public UserConverter getUserConverter() {
        return userConverter;
    }

    public void setUserConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    public CategoryProduitConverter getCategoryProduitConverter() {
        return categoryProduitConverter;
    }

    public void setCategoryProduitConverter(CategoryProduitConverter categoryProduitConverter) {
        this.categoryProduitConverter = categoryProduitConverter;
    }
}