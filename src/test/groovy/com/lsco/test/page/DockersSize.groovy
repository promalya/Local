package com.lsco.test.page

enum DockersSize {
    S("S",0),
    M("M",1),
    L("L", 2),
    XL("XL", 3),
	XS("XS",4)

    private final String size
    private final int value


    DockersSize(String size,int value){
        this.size = size
        this.value= value
    }
    public static String getSize(int value)  {
        switch (value){
            case 0:
                return "S";
            case 1:
                return "M";
            case 2:
                return "L";
            case 3:
                return "XL";
			case 4:
				return "XS";
        }
    }

    public static double getValue(String size) {
        size=size.toUpperCase()
        switch (size){
            case "S":
                return 0;
            case "M":
                return 1;
            case "L":
                return 2;
            case "XL":
                return 2;
			case "XS":
				return 4;
        }
    }
}