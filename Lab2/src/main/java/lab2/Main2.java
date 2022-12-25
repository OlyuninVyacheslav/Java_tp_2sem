package lab2;

public class Main2 {
    public static void main(String[] args) {
        IActions[] players = {
                new Human("Человек", 500,2),
                new Cat("Кот",700,3),
                new Robot("Робот",600,1)};

        Obstacle[] obstacles = {
                new Track(500,0),
                new Wall(0,2),
                new Track(600,0),
                new Wall(0,3)};


        for (Obstacle o: obstacles)
        {
            for (IActions p : players)
            {
                if (o.height==0)
                {
                    if (p.run() >= o.dist)
                    {
                        System.out.println(p.name() + " пробежал беговую дорожку, длиной " + o.dist + "м");
                    }

                }
                else
                {
                    if (p.jump() >= o.height)
                    {
                        System.out.println(p.name() + " перепрыгнул стену, высотой " + o.height + "м");
                    }
                }
            }
            System.out.println("");
        }


    }
}

