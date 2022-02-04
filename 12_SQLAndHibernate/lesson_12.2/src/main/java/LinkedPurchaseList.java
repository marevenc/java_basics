import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListPK id;

    public LinkedPurchaseListPK getId() {
        return id;
    }

    public void setId(LinkedPurchaseListPK id) {
        this.id = id;
    }
}
