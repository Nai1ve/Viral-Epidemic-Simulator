package com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.AbstractMap;
import java.awt.Point;
import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Building.Building;
import com.mygdx.viralepidemicsim.SimulationV4UsedLibgdx.Helpers.GameInfo;

/**
 * this class is the map for the simulation
 */
public class GridMap {

    /**
     * constructs the GridMap object, and calls the methods to build the map
     */
    public GridMap() {
        fillVertices();
        fillGraph();
        buildingBuilder();
        for(int i = 0; i < vertices.length ; i++){
            vertices[i].y -= 90;
            vertices[i].x += 45;
        }

    }

    public GridMap(int[][] arr){
        gridMap = arr;
    }

    /**
     * Creates building objects and stores them in the buildings array
     */
    public void buildingBuilder() {
        buildings[0] = new Building("Hospital",new Point(340,9758),250*320);
        buildings[1] = new Building("House0",new Point(450,9865),15000);
        buildings[2] = new Building("House1",new Point(615,9865),15000);
        buildings[3] = new Building("House2",new Point(780,9865),15000);
        buildings[4] = new Building("House3",new Point(945,9865),15000);
        buildings[5] = new Building("Cafe",new Point(1145,9865),15000);
        //parks size is too big because people should not get infected at outdoors
        buildings[6] = new Building("Park0",new Point(1525,9750),999999);
        buildings[7] = new Building("SportCenter",new Point(1585,9710),230*215);
        buildings[8] = new Building("House4",new Point(450,9650),15000);
        buildings[9] = new Building("House5",new Point(615,9650),15000);
        buildings[10] = new Building("Market",new Point(780,9650),15000);
        buildings[11] = new Building("House6",new Point(945,9650),15000);
        buildings[12] = new Building("House7",new Point(1145,9650),15000);
        buildings[13] = new Building("House8",new Point(145,9430),25000);
        buildings[14] = new Building("PoliceStation",new Point(400,9420),21000);
        buildings[15] = new Building("BowlingClub",new Point(615,9590),63000);
        buildings[16] = new Building("School",new Point(875,9510),250*210);
        buildings[17] = new Building("Mosque",new Point(1195,9590),180*210);
        buildings[18] = new Building("House9",new Point(1395,9590),190*105);
        buildings[19] = new Building("House10",new Point(1395,9380),190*105);
        buildings[20] = new Building("EmptyArea",new Point(1585,9410),230*210);
        buildings[21] = new Building("House11",new Point(145,9365),250*90);
        buildings[22] = new Building("AkgulEvYemekler",new Point(340,9210),250*100);
        buildings[23] = new Building("House12",new Point(400,9310),19000);
        buildings[24] = new Building("Park1",new Point(815,9260),57000);
        buildings[25] = new Building("Mall",new Point(945,9320),50000);
        buildings[26] = new Building("GovOffice",new Point(1195,9320),230*135);
        buildings[27] = new Building("Factory",new Point(1535,9320),480*250);
        buildings[28] = new Building("House13",new Point(145,9070),250*90);
        buildings[29] = new Building("WalkingPath",new Point(645,9070),415*90);
        buildings[30] = new Building("House14",new Point(1190,9070),23000);
    }


    //instantiative variables
    public Building[] buildings = new Building[31];
    public Point[] vertices = new Point[157];
    public int[][] gridMap = new int[157][157];

    /**
     * fills the map with map's vertices
     */
    public void fillVertices() {
        vertices[0] = new Point(295,GameInfo.HEIGHT - 152);
        vertices[1] = new Point(405,GameInfo.HEIGHT -45); 
        vertices[2] = new Point(570,GameInfo.HEIGHT -45); 
        vertices[3] = new Point(735,GameInfo.HEIGHT -45); 
        vertices[4] = new Point(900,GameInfo.HEIGHT -45); 
        vertices[5] = new Point(1100,GameInfo.HEIGHT -45); 
        vertices[6] = new Point(1480,GameInfo.HEIGHT -160); 
        vertices[7] = new Point(1540,GameInfo.HEIGHT -200); 
        vertices[8] = new Point(405,GameInfo.HEIGHT -260); 
        vertices[9] = new Point(570,GameInfo.HEIGHT -260); 
        vertices[10] = new Point(735,GameInfo.HEIGHT -260);
        vertices[11] = new Point(900,GameInfo.HEIGHT -260);
        vertices[12] = new Point(1100,GameInfo.HEIGHT -260);
        vertices[13] = new Point(100,GameInfo.HEIGHT -480);
        vertices[14] = new Point(355,GameInfo.HEIGHT -490);
        vertices[15] = new Point(570,GameInfo.HEIGHT -320);
        vertices[16] = new Point(830,GameInfo.HEIGHT -400);
        vertices[17] = new Point(1150,GameInfo.HEIGHT -320);
        vertices[18] = new Point(1350,GameInfo.HEIGHT -320);
        vertices[19] = new Point(1350,GameInfo.HEIGHT -530);
        vertices[20] = new Point(1540,GameInfo.HEIGHT -500);
        vertices[21] = new Point(100,GameInfo.HEIGHT -545);
        vertices[22] = new Point(295,GameInfo.HEIGHT -700);
        vertices[23] = new Point(355,GameInfo.HEIGHT -600);
        vertices[24] = new Point(770,GameInfo.HEIGHT -650);
        vertices[25] = new Point(900,GameInfo.HEIGHT -590);
        vertices[26] = new Point(1150,GameInfo.HEIGHT -590);
        vertices[27] = new Point(1490,GameInfo.HEIGHT -590);
        vertices[28] = new Point(100,GameInfo.HEIGHT -840);
        vertices[29] = new Point(600,GameInfo.HEIGHT -840);
        vertices[30] = new Point(1145,GameInfo.HEIGHT -840);
        vertices[31] = new Point(300,GameInfo.HEIGHT -152);
        vertices[32] = new Point(305,GameInfo.HEIGHT -152);
        vertices[33] = new Point(405,GameInfo.HEIGHT -40);
        vertices[34] = new Point(405,GameInfo.HEIGHT -35);
        vertices[35] = new Point(570,GameInfo.HEIGHT -40);
        vertices[36] = new Point(570,GameInfo.HEIGHT -35);
        vertices[37] = new Point(735,GameInfo.HEIGHT -40);
        vertices[38] = new Point(735,GameInfo.HEIGHT -35);
        vertices[39] = new Point(900,GameInfo.HEIGHT -40);
        vertices[40] = new Point(900,GameInfo.HEIGHT -35);
        vertices[41] = new Point(1100,GameInfo.HEIGHT -40);
        vertices[42] = new Point(1485,GameInfo.HEIGHT -160);
        vertices[43] = new Point(1490,GameInfo.HEIGHT -160);
        vertices[44] = new Point(1535,GameInfo.HEIGHT -200);
        vertices[45] = new Point(1530,GameInfo.HEIGHT -200);
        vertices[46] = new Point(405,GameInfo.HEIGHT -265);
        vertices[47] = new Point(405,GameInfo.HEIGHT -270);
        vertices[48] = new Point(570,GameInfo.HEIGHT -265);
        vertices[49] = new Point(570,GameInfo.HEIGHT -270);
        vertices[50] = new Point(735,GameInfo.HEIGHT -265);
        vertices[51] = new Point(735,GameInfo.HEIGHT -270);
        vertices[52] = new Point(900,GameInfo.HEIGHT -265);
        vertices[53] = new Point(900,GameInfo.HEIGHT -270);
        vertices[54] = new Point(1100,GameInfo.HEIGHT -265);
        vertices[55] = new Point(1100,GameInfo.HEIGHT -270);
        vertices[56] = new Point(100,GameInfo.HEIGHT -485);
        vertices[57] = new Point(100,GameInfo.HEIGHT -490);
        vertices[58] = new Point(350,GameInfo.HEIGHT -490);
        vertices[59] = new Point(345,GameInfo.HEIGHT -490);
        vertices[60] = new Point(570,GameInfo.HEIGHT -315);
        vertices[61] = new Point(570,GameInfo.HEIGHT -310);
        vertices[62] = new Point(825,GameInfo.HEIGHT -400);
        vertices[63] = new Point(820,GameInfo.HEIGHT -400);
        vertices[64] = new Point(1150,GameInfo.HEIGHT -315);
        vertices[65] = new Point(1150,GameInfo.HEIGHT -310);
        vertices[66] = new Point(1350,GameInfo.HEIGHT -315);
        vertices[67] = new Point(1350,GameInfo.HEIGHT -310);
        vertices[68] = new Point(1350,GameInfo.HEIGHT -535);
        vertices[69] = new Point(1350,GameInfo.HEIGHT -540);
        vertices[70] = new Point(1535,GameInfo.HEIGHT -500);
        vertices[71] = new Point(1530,GameInfo.HEIGHT -500);
        vertices[72] = new Point(100,GameInfo.HEIGHT -540);
        vertices[73] = new Point(100,GameInfo.HEIGHT -535);
        vertices[74] = new Point(300,GameInfo.HEIGHT -700);
        vertices[75] = new Point(305,GameInfo.HEIGHT -700);
        vertices[76] = new Point(350,GameInfo.HEIGHT -600);
        vertices[77] = new Point(345,GameInfo.HEIGHT -600);
        vertices[78] = new Point(775,GameInfo.HEIGHT -650);
        vertices[79] = new Point(780,GameInfo.HEIGHT -650);
        vertices[80] = new Point(900,GameInfo.HEIGHT -585);
        vertices[81] = new Point(900,GameInfo.HEIGHT -580);
        vertices[82] = new Point(1150,GameInfo.HEIGHT -585);
        vertices[83] = new Point(1150,GameInfo.HEIGHT -580);
        vertices[84] = new Point(1490,GameInfo.HEIGHT -585);
        vertices[85] = new Point(1490,GameInfo.HEIGHT -580);
        vertices[86] = new Point(100,GameInfo.HEIGHT -845);
        vertices[87] = new Point(100,GameInfo.HEIGHT -850);
        vertices[88] = new Point(600,GameInfo.HEIGHT -845);
        vertices[89] = new Point(600,GameInfo.HEIGHT -850);
        vertices[90] = new Point(1145,GameInfo.HEIGHT -845);
        vertices[91] = new Point(1145,GameInfo.HEIGHT -850);
        vertices[92] = new Point(35,GameInfo.HEIGHT -35);
        vertices[93] = new Point(40,GameInfo.HEIGHT -40);
        vertices[94] = new Point(305,GameInfo.HEIGHT -35);
        vertices[95] = new Point(300,GameInfo.HEIGHT -40);
        vertices[96] = new Point(35,GameInfo.HEIGHT -490);
        vertices[97] = new Point(40,GameInfo.HEIGHT -485);
        vertices[98] = new Point(300,GameInfo.HEIGHT -485);
        vertices[99] = new Point(305,GameInfo.HEIGHT -490);
        vertices[100] = new Point(350,GameInfo.HEIGHT -40);
        vertices[101] = new Point(345,GameInfo.HEIGHT -35);
        vertices[102] = new Point(1485,GameInfo.HEIGHT -40);
        vertices[103] = new Point(1490,GameInfo.HEIGHT -35);
        vertices[104] = new Point(1535,GameInfo.HEIGHT -40);
        vertices[105] = new Point(1530,GameInfo.HEIGHT -35);
        vertices[106] = new Point(1775,GameInfo.HEIGHT -40);
        vertices[107] = new Point(1780,GameInfo.HEIGHT -35);
        vertices[108] = new Point(1535,GameInfo.HEIGHT -265);
        vertices[109] = new Point(1530,GameInfo.HEIGHT -270);
        vertices[110] = new Point(1775,GameInfo.HEIGHT -265);
        vertices[111] = new Point(1780,GameInfo.HEIGHT -270);
        vertices[112] = new Point(350,GameInfo.HEIGHT -265);
        vertices[113] = new Point(345,GameInfo.HEIGHT -270);
        vertices[114] = new Point(1485,GameInfo.HEIGHT -265);
        vertices[115] = new Point(1490,GameInfo.HEIGHT -270);
        vertices[116] = new Point(345,GameInfo.HEIGHT -310);
        vertices[117] = new Point(350,GameInfo.HEIGHT -315);
        vertices[118] = new Point(775,GameInfo.HEIGHT -315);
        vertices[119] = new Point(780,GameInfo.HEIGHT -310);
        vertices[120] = new Point(825,GameInfo.HEIGHT -315);
        vertices[121] = new Point(820,GameInfo.HEIGHT -310);
        vertices[122] = new Point(1485,GameInfo.HEIGHT -315);
        vertices[123] = new Point(1490,GameInfo.HEIGHT -310);
        vertices[124] = new Point(1535,GameInfo.HEIGHT -315);
        vertices[125] = new Point(1530,GameInfo.HEIGHT -310);
        vertices[126] = new Point(1775,GameInfo.HEIGHT  -315);
        vertices[127] = new Point(1780,GameInfo.HEIGHT  -310);
        vertices[128] = new Point(40,GameInfo.HEIGHT -540);
        vertices[129] = new Point(35,GameInfo.HEIGHT -535);
        vertices[130] = new Point(300,GameInfo.HEIGHT -540);
        vertices[131] = new Point(305,GameInfo.HEIGHT -535);
        vertices[132] = new Point(825,GameInfo.HEIGHT -535);
        vertices[133] = new Point(820,GameInfo.HEIGHT -540);
        vertices[134] = new Point(1485,GameInfo.HEIGHT -535);
        vertices[135] = new Point(1490,GameInfo.HEIGHT -540);
        vertices[136] = new Point(1535,GameInfo.HEIGHT -535);
        vertices[137] = new Point(1530,GameInfo.HEIGHT -540);
        vertices[138] = new Point(1775,GameInfo.HEIGHT -535);
        vertices[139] = new Point(1780,GameInfo.HEIGHT -540);
        vertices[140] = new Point(40,GameInfo.HEIGHT -845);
        vertices[141] = new Point(35,GameInfo.HEIGHT -850);
        vertices[142] = new Point(300,GameInfo.HEIGHT -845);
        vertices[143] = new Point(305,GameInfo.HEIGHT -850);
        vertices[144] = new Point(350,GameInfo.HEIGHT -845);
        vertices[145] = new Point(345,GameInfo.HEIGHT -850);
        vertices[146] = new Point(775,GameInfo.HEIGHT -845);
        vertices[147] = new Point(780,GameInfo.HEIGHT -850);
        vertices[148] = new Point(825,GameInfo.HEIGHT -585);
        vertices[149] = new Point(820,GameInfo.HEIGHT -580);
        vertices[150] = new Point(1775,GameInfo.HEIGHT -585);
        vertices[151] = new Point(1780,GameInfo.HEIGHT -580);
        vertices[152] = new Point(825,GameInfo.HEIGHT -845);
        vertices[153] = new Point(820,GameInfo.HEIGHT -850);
        vertices[154] = new Point(1775,GameInfo.HEIGHT -845);
        vertices[155] = new Point(1780,GameInfo.HEIGHT -850);
        vertices[156] = new Point(1100,GameInfo.HEIGHT -35);
    }

    /**
     * this methd adds directed edges to the grap
     */
    public void fillGraph(){
        addEdge(0,31 );
        addEdge(0,32 );
        addEdge(1, 33);
        addEdge(1, 34);
        addEdge(2, 35);
        addEdge(2, 36);
        addEdge(3, 37,38);
        addEdge(4, 39,40);
        addEdge(5, 41,156);
        addEdge(6, 42,43);
        addEdge(7, 44,45);
        addEdge(8, 46,47);
        addEdge(9, 48,49);
        addEdge(10, 50,51);
        addEdge(11, 52,53);
        addEdge(12, 54,55);
        addEdge(13, 56,57);
        addEdge(14, 58,59);
        addEdge(15, 60,61);
        addEdge(16, 62,63);
        addEdge(17, 64,65);
        addEdge(18, 66,67);
        addEdge(19, 68,69);
        addEdge(20, 70,71);
        addEdge(21, 72,73);
        addEdge(22, 74,75);
        addEdge(23, 76,77);
        addEdge(24, 78,79);
        addEdge(25, 80,81);
        addEdge(26, 82,83);
        addEdge(27, 84,85);
        addEdge(28, 86,87);
        addEdge(29, 88,89);
        addEdge(30, 90,91);
        addEdge(31,0,32,98,95);
        addEdge(32, 31,94 );
        addEdge(33, 1,34,35);
        addEdge(34, 33,101);
        addEdge(35, 2,36,37);
        addEdge(36, 35,34);
        addEdge(37, 3,38,39);
        addEdge(38, 37,36);
        addEdge(39, 40,4,41);
        addEdge(40, 39,38);
        addEdge(41, 5,156,102);
        addEdge(42, 6,43,114 );
        addEdge(43, 42, 103);
        addEdge(44, 7, 45,104);
        addEdge(45, 44, 109);
        addEdge(46, 47,8 ,12);
        addEdge(47, 46, 49);
        addEdge(48, 49,9,46);
        addEdge(49, 48,51);
        addEdge(50, 51,10,48 );
        addEdge(51, 50, 53);
        addEdge(52, 53,11,50 );
        addEdge(53, 52,55);
        addEdge(54, 55,12, 52);
        addEdge(55, 54, 111);
        addEdge(56, 57,13,97);
        addEdge(57, 56,99);
        addEdge(58, 14,59,117);
        addEdge(59, 58,77);
        addEdge(60, 61,15,118);
        addEdge(61,60, 116);
        addEdge(62, 63, 16,120 );
        addEdge(63, 62, 133 );
        addEdge(64, 65, 17, 66);
        addEdge(65, 64, 121);
        addEdge(66, 67, 122, 18 );
        addEdge(67, 66, 65);
        addEdge(68, 69, 19, 132);
        addEdge(69, 68, 135);
        addEdge(70, 71, 20, 124);
        addEdge(71, 70, 137);
        addEdge(72, 73, 21, 130);
        addEdge(73, 72, 129);
        addEdge(74, 75, 22, 142);
        addEdge(75, 74, 131);
        addEdge(76, 77, 23, 58);
        addEdge(77, 76, 145);
        addEdge(78, 79, 24, 146 );
        addEdge(79, 78, 119);
        addEdge(80, 81, 25, 82);
        addEdge(81, 80, 149);
        addEdge(82, 83, 26, 84);
        addEdge(83, 82, 81);
        addEdge(84, 85, 27, 150);
        addEdge(85, 84, 83);
        addEdge(86, 87, 28, 140);
        addEdge(87, 86, 143);
        addEdge(88, 89, 29, 144);
        addEdge(89, 88, 147);
        addEdge(90, 91, 30, 152);
        addEdge(91, 90, 155);
        addEdge(92, 96);
        addEdge(93, 95);
        addEdge(94, 92, 101);
        addEdge(95, 31, 100);
        addEdge(96, 57, 129);
        addEdge(97, 93, 128);
        addEdge(98, 56, 130);
        addEdge(99, 32, 131);
        addEdge(100, 33, 102,95);
        addEdge(101, 113,94);
        addEdge(102, 42, 114, 104);
        addEdge(103, 156, 40, 101, 105, 38, 36, 34);
        addEdge(104, 106, 102);
        addEdge(105, 103, 109, 45);
        addEdge(106, 110);
        addEdge(107, 105);
        addEdge(108, 114, 124, 104);
        addEdge(109, 115, 125, 111);
        addEdge(110, 126, 108);
        addEdge(111, 127, 107);
        addEdge(112, 117);
        addEdge(113, 116, 47 , 49, 51 , 53, 55, 115);
        addEdge(114, 108, 122, 46, 48, 50, 52, 54);
        addEdge(114, 112);
        addEdge(115, 109,123,43,103);
        addEdge(116, 113,59,77,145);
        addEdge(117, 112,60,118);
        addEdge(118, 120,78,146);
        addEdge(119, 121,61,116);
        addEdge(120, 118,64,66,122);
        addEdge(121, 119,133);
        addEdge(122, 114,124,134);
        addEdge(123, 115,125,67,65,121);
        addEdge(124,122,126);
        addEdge(125, 109,123,71,137);
        addEdge(126, 110,138);
        addEdge(127, 111,125);
        addEdge(128, 97,72,130);
        addEdge(129, 96,73,141);
        addEdge(130, 74,98);
        addEdge(131, 73,99);
        addEdge(132, 62,148);
        addEdge(133, 69,149);
        addEdge(134, 68,136);
        addEdge(135, 123,137);
        addEdge(136, 70,134);
        addEdge(137, 139,135);
        addEdge(138, 136,150);
        addEdge(139, 127,151);
        addEdge(140, 128);
        addEdge(141, 87);
        addEdge(142, 86,144);
        addEdge(143, 75,145);
        addEdge(144, 76,142);
        addEdge(145, 89,143);
        addEdge(146, 88,152);
        addEdge(147, 79,153);
        addEdge(148, 80,132);
        addEdge(149, 153,133);
        addEdge(150, 154,138);
        addEdge(151, 85,139);
        addEdge(152, 148,146);
        addEdge(153, 91,147);
        addEdge(154, 90);
        addEdge(155, 151);
        addEdge(156, 41,40);

        addEdge(92, 93);
        addEdge(93, 92);
        addEdge(94, 95);
        addEdge(95, 94);
        addEdge(100, 101);
        addEdge(101, 100);

        addEdge(102, 103);

        addEdge(103, 102);


        addEdge(104, 105);
        addEdge(105, 104);
        addEdge(106, 107);
        addEdge(107, 106);
        addEdge(112, 113);

        addEdge(113, 112);
        addEdge(114, 115);
        addEdge(115, 114);
        addEdge(108, 109);
        addEdge(109, 108);
        addEdge(110, 111);
        addEdge(111, 110);

        addEdge(116, 117);
        addEdge(117, 116);
        addEdge(118, 119);
        addEdge(119, 118);
        addEdge(120, 121);
        addEdge(121, 120);
        addEdge(122, 123);
        addEdge(123, 122);
        addEdge(124, 125);
        addEdge(125, 124);
        
        addEdge(126, 127);
        addEdge(127, 126);
        addEdge(96, 97);
        addEdge(97, 96);
        addEdge(98, 99);
        addEdge(99, 98);
        addEdge(128, 129);
        addEdge(129, 128);
        addEdge(130, 131);
        addEdge(131, 130);
        addEdge(152, 153);
        addEdge(153, 152);
        addEdge(134, 133);
        addEdge(133, 134);
        addEdge(136, 137);
        addEdge(137, 136);
        addEdge(138, 139);
        addEdge(139, 138);
        addEdge(148, 149);
        addEdge(149, 148);
        addEdge(150, 151);
        addEdge(151, 150);
        addEdge(141, 140);
        addEdge(140, 141);
        addEdge(142, 143);
        addEdge(143, 142);
        addEdge(144, 145);
        addEdge(145, 144);
        addEdge(146, 147);
        addEdge(147, 146);
        addEdge(152, 153);
        addEdge(153, 152);
        addEdge(154, 155);
        addEdge(155, 154);

    }

    /**
     * this method adds directed lines to the graph(map).
     * @param indexFirst base point of the edge
     * @param indexSecond destination point of the edge
     */
    public void addEdge(int indexFirst, int indexSecond) {
        this.gridMap[indexFirst][indexSecond] =
        (int)(vertices[indexFirst].distance(vertices[indexSecond]));
    }
    public void addEdge(int indexFirst, int indexSecond, int indexThird) {
        addEdge(indexFirst, indexSecond);
        addEdge(indexFirst, indexThird);
    }

    public void addEdge(int indexFirst, int indexSecond, int indexThird, int indexFourth) {
        addEdge(indexFirst, indexSecond);
        addEdge(indexFirst, indexThird);
        addEdge(indexFirst, indexFourth);
    }

    public void addEdge(int indexFirst, int indexSecond, int indexThird, int indexFourth, int indexFifth) {
        addEdge(indexFirst, indexSecond);
        addEdge(indexFirst, indexThird);
        addEdge(indexFirst, indexFourth);
        addEdge(indexFirst, indexFifth);
    }

    public void addEdge(int indexFirst, int indexSecond, int indexThird, int indexFourth, int indexFifth, int indexSixth) {
        addEdge(indexFirst, indexSecond);
        addEdge(indexFirst, indexThird);
        addEdge(indexFirst, indexFourth);
        addEdge(indexFirst, indexFifth);
        addEdge(indexFirst, indexSixth);
    }

    public void addEdge(int indexFirst, int indexSecond, int indexThird, int indexFourth, int indexFifth, int indexSixth, int indexSeventh) {
        addEdge(indexFirst, indexSecond);
        addEdge(indexFirst, indexThird);
        addEdge(indexFirst, indexFourth);
        addEdge(indexFirst, indexFifth);
        addEdge(indexFirst, indexSixth);
        addEdge(indexFirst, indexSeventh);
    }

    public void addEdge(int indexFirst, int indexSecond, int indexThird, int indexFourth, int indexFifth, int indexSixth, int indexSeventh, int indexEighth) {
        addEdge(indexFirst, indexSecond);
        addEdge(indexFirst, indexThird);
        addEdge(indexFirst, indexFourth);
        addEdge(indexFirst, indexFifth);
        addEdge(indexFirst, indexSixth);
        addEdge(indexFirst, indexSeventh);
        addEdge(indexFirst, indexEighth);
    }

    public String toString(){
        String res = "";
        for(int i = 0; i < vertices.length; i++){
            res = res + Arrays.toString(gridMap[i]) + "\n";
        }
        return res;
    }

}
