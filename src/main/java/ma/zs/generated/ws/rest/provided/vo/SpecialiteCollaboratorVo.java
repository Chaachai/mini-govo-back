package ma.zs.generated.ws.rest.provided.vo;

import ma.zs.generated.bean.CategoryProduit;
import ma.zs.generated.bean.User;

public class SpecialiteCollaboratorVo {
    private String id;
    private CategoryProduitVo categoryProduitVo;
    private UserVo collaboratorVo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CategoryProduitVo getCategoryProduitVo() {
        return categoryProduitVo;
    }

    public void setCategoryProduitVo(CategoryProduitVo categoryProduitVo) {
        this.categoryProduitVo = categoryProduitVo;
    }

    public UserVo getCollaboratorVo() {
        return collaboratorVo;
    }

    public void setCollaboratorVo(UserVo collaboratorVo) {
        this.collaboratorVo = collaboratorVo;
    }
}
