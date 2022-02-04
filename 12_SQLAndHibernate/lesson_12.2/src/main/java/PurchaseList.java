import javax.persistence.*;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {
    @EmbeddedId
    private PurchaseListPK id;

    public PurchaseListPK getId() {
        return id;
    }

    public void setId(PurchaseListPK id) {
        this.id = id;
    }
}
