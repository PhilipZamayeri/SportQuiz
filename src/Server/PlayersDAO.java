package Server;

import java.io.Serializable;

public class PlayersDAO implements Serializable {
    private String name;

    public PlayersDAO(String namn){
        this.name=namn;
    }

    public void setNamn(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
