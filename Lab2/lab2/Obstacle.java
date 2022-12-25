package lab2;

public abstract class Obstacle {
    protected Integer dist;
    protected Integer height;

    public Integer getDist() {
        return dist;
    }

    public void setDist(Integer dist) {
        this.dist = dist;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Obstacle(Integer dist, Integer height) {
        this.dist = dist;
        this.height = height;
    }
}
