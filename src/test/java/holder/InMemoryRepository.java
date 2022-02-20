package holder;

import com.intellij.dvcs.repo.Repository;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.vcs.AbstractVcs;
import com.intellij.openapi.vfs.VirtualFile;
import com.revature.cardex.Car;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public class InMemoryRepository implements Repository {
    private List<Car> classicCars;

    public InMemoryRepository() {
        classicCars = new ArrayList<>();
        classicCars.add(new Car("Mazda RX4", 21, 110));
    }

    public List<Car> getClassicCars() {return classicCars;}

    public Car getCars(String carModel) {
        Car result = null;
        for (Car cars : this.classicCars) {
            if (cars.getCarModel().equals(carModel)) {
                result = cars;
            }

        }
        return result;
    }

    @Override
    public @NotNull VirtualFile getRoot() {
        return null;
    }

    @Override
    public @NlsSafe @NotNull String getPresentableUrl() {
        return null;
    }

    @Override
    public @NotNull Project getProject() {
        return null;
    }

    @Override
    public @NotNull State getState() {
        return null;
    }

    @Override
    public @NlsSafe @Nullable String getCurrentBranchName() {
        return null;
    }

    @Override
    public @NotNull AbstractVcs getVcs() {
        return null;
    }

    @Override
    public @NlsSafe @Nullable String getCurrentRevision() {
        return null;
    }

    @Override
    public boolean isFresh() {
        return false;
    }

    @Override
    public void update() {

    }

    @Override
    public @NonNls @NotNull String toLogString() {
        return null;
    }

    @Override
    public void dispose() {

    }
}

