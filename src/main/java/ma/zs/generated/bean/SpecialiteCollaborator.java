package ma.zs.generated.bean;

import javax.persistence.*;

@Entity
public class SpecialiteCollaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private CategoryProduit categoryProduit;
    @ManyToOne
    private User collaborator;


    public SpecialiteCollaborator() {super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryProduit getCategoryProduit() {
        return categoryProduit;
    }

    public void setCategoryProduit(CategoryProduit categoryProduit) {
        this.categoryProduit = categoryProduit;
    }

    public User getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(User collaborator) {
        this.collaborator = collaborator;
    }
}
