package lab2;

public class Human implements IActions{
    private String name;
    private Integer run_dist;
    private Integer jump_height;


    public void setName(String name) {
        this.name = name;
    }

    public void setRun_dist(Integer run_dist) {
        this.run_dist = run_dist;
    }


    public void setJump_height(Integer jump_height) {
        this.jump_height = jump_height;
    }

    public Human(String name, Integer run_dist, Integer jump_height) {
        this.name = name;
        this.run_dist = run_dist;
        this.jump_height = jump_height;
    }

    @Override
    public Integer run() {
        return run_dist;
    }

    @Override
    public Integer jump() {
        return jump_height;
    }

    @Override
    public String name() {
        return name;
    }
}
