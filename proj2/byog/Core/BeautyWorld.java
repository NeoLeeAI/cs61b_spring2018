package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a beautiful world contains RANDOM rooms and hallways.
 */
public class BeautyWorld {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

    private static long seed;
    private static Random RANDOM;

    public static class Position {
        public int x;
        public int y;

        //Determine the direction of room expansion
        public String NSEW;
        public Position(int xCoord, int yCoord) {
            x = xCoord;
            y = yCoord;
        }
    }

    public BeautyWorld(long seed) {
        BeautyWorld.seed = seed;
        RANDOM = new Random(seed);
    }

    public  static void drawOnePoint(TETile[][] world, Position p, TETile t) {
        world[p.x][p.y] = t;
    }

    // Determine the starting location of the room
    public static Position[] roomPositions() {
        // 生成一个20到40之间的随机数
        int roomNum = RANDOM.nextInt(21) + 20;
        Position[] positions = new Position[roomNum];
        int pointsPerQuadrant = roomNum / 4;

        for (int i = 0; i < pointsPerQuadrant; i++) {
            // 第一象限（右上角）
            positions[4*i] = new Position(WIDTH / 2 + RANDOM.nextInt(WIDTH / 2), HEIGHT / 2 + RANDOM.nextInt(HEIGHT / 2));
            // 第二象限（左上角）
            positions[4*i + 1] = new Position(RANDOM.nextInt(WIDTH / 2), HEIGHT / 2 + RANDOM.nextInt(HEIGHT / 2));
            // 第三象限（左下角）
            positions[4*i + 2] = new Position(RANDOM.nextInt(WIDTH / 2), RANDOM.nextInt(HEIGHT / 2));
            // 第四象限（右下角）
            positions[4*i + 3] = new Position(WIDTH / 2 + RANDOM.nextInt(WIDTH / 2), RANDOM.nextInt(HEIGHT / 2));
        }

        // 如果 roomNum 不是4的倍数，处理剩余的点
        for (int i = pointsPerQuadrant * 4; i < roomNum; i++) {
            int quadrant = i % 4;
            switch (quadrant) {
                case 0:
                    positions[i] = new Position(WIDTH / 2 + RANDOM.nextInt(WIDTH / 2), HEIGHT / 2 + RANDOM.nextInt(HEIGHT / 2));
                    break;
                case 1:
                    positions[i] = new Position(RANDOM.nextInt(WIDTH / 2), HEIGHT / 2 + RANDOM.nextInt(HEIGHT / 2));
                    break;
                case 2:
                    positions[i] = new Position(RANDOM.nextInt(WIDTH / 2), RANDOM.nextInt(HEIGHT / 2));
                    break;
                case 3:
                    positions[i] = new Position(WIDTH / 2 + RANDOM.nextInt(WIDTH / 2), RANDOM.nextInt(HEIGHT / 2));
                    break;
            }
        }
        return positions;
    }

    // Set the direction of room expansion
    public static void setRoomNSEW(Position[] positions) {
        for (Position p: positions) {
            int temp = RANDOM.nextInt(4);
            switch (temp) {
                case 0:
                    p.NSEW = "up";
                    break;
                case 1:
                    p.NSEW = "down";
                    break;
                case 2:
                    p.NSEW = "right";
                    break;
                case 3:
                    p.NSEW = "left";
                    break;
            }
        }
    }

    public static void drawRoom(TETile[][] world, Position[] positions, TETile t) {
        for (int i = 0; i < 6; i++) {

        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        RANDOM = new Random(123);
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = new TETile[WIDTH][HEIGHT];

        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        Position[] p = roomPositions();
        for (Position position : p) {
            drawOnePoint(world, position, Tileset.FLOWER);
        }
        ter.renderFrame(world);
    }
}
