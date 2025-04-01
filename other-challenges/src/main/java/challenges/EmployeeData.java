package technical.challenges;

import java.util.Arrays;
import java.util.Objects;

public class EmployeeData {
    private String name;
    private int[][] coordinates;
    private Integer area;

    public EmployeeData(String name, int[][] coordinates, Integer area) {
        this.name = name;
        this.coordinates = coordinates;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[][] coordinates) {
        this.coordinates = coordinates;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "EmployeeData{" + "name='" + name + '\'' + ", coordinates=" +
               Arrays.toString(coordinates) + ", area=" + area + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeData that = (EmployeeData) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, area);
        result = 31 * result + Arrays.hashCode(coordinates);
        return result;
    }
}
