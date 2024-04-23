package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long carId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column(name = "model")
    private String model;

    @Column(name = "serios")
    private int seriosNumber;

    public Car() {

    }

    public Car(User user, String model, int seriosNumber) {
        this.user = user;
        this.model = model;
        this.seriosNumber = seriosNumber;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeriosNumber() {
        return seriosNumber;
    }

    public void setSeriosNumber(int seriosNumber) {
        this.seriosNumber = seriosNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", user=" + user +
                ", model='" + model + '\'' +
                ", seriosNumber=" + seriosNumber +
                '}';

    }
}