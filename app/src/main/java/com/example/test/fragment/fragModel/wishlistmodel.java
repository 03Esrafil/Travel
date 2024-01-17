package com.example.test.fragment.fragModel;

public class wishlistmodel {
    public int imge;
    public String imgetile;

    public wishlistmodel(int imge, String imgetile) {
        this.imge = imge;
        this.imgetile = imgetile;
    }

    public int getImge() {
        return imge;
    }

    public void setImge(int imge) {
        this.imge = imge;
    }

    public String getImgetile() {
        return imgetile;
    }

    public void setImgetile(String imgetile) {
        this.imgetile = imgetile;
    }
}
