import java.io.Serializable;

public class ProjectBullet implements Serializable {
    private int id;
    private String bulletpoint;

    public ProjectBullet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBulletpoint() {
        return bulletpoint;
    }

    public void setBulletpoint(String bulletpoint) {
        this.bulletpoint = bulletpoint;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProjectBullet other = (ProjectBullet) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjectBullet{" + "id=" + id + ", bulletpoint=" + bulletpoint + '}';
    }
}
