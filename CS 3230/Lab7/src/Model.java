import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Random;

public class Model extends JFrame {

    public TileDeck tileDeck = new TileDeck();

    private final int xSize = 9;
    private final int ySize = 16;
    private final int layerSize = 5;

    private int gameNumber;
    //NEW
    private ScrollDemo removedTiles;
    private Tile selected;
    private GameBoard board;

    public Model(int gameNumber) {
        this.gameNumber = gameNumber;
        removedTiles = new ScrollDemo();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(970, 600);
        board = new GameBoard();
        createBottomPane();
        add(board);
        setVisible(true);
    }

    /**
     * Class GameBoards uses TileDeck instance to add tiles.
     */
    public class GameBoard extends JPanel implements MouseListener {

        private Image backgroundImage;

        private Tile[][][] tiles;

        public GameBoard() {
            setLayout(null);
            tiles = new Tile[xSize][ySize][layerSize];
            setUpTiles();
        }

        /**
         * Method for building and adding the layers and tiles for the MahJong board.
         */
        private void setUpTiles() {
            tiles[4][7][4] = tileDeck.deal();
            tiles[4][7][4].setCoordinates(4, 7, 4);
            positionTile(tiles[4][7][4], 4, 7, 4);
            for (int col = 6; col < 8; col++) {
                for (int row = 4; row > 2; row--) {
                    tiles[row][col][3] = tileDeck.deal();
                    tiles[row][col][3].setCoordinates(row, col, 3);
                    positionTile(tiles[row][col][3], row, col, 3);
                }
            }
            for (int col = 5; col < 9; col++) {
                for (int row = 5; row > 1; row--) {
                    tiles[row][col][2] = tileDeck.deal();
                    tiles[row][col][2].setCoordinates(row, col, 2);
                    positionTile(tiles[row][col][2], row, col, 2);
                }
            }
            for (int col = 4; col < 10; col++) {
                for (int row = 6; row > 0; row--) {
                    tiles[row][col][1] = tileDeck.deal();
                    tiles[row][col][1].setCoordinates(row, col, 1);
                    positionTile(tiles[row][col][1], row, col, 1);
                }
            }
            for (int col = 1; col < 13; col++) {
                tiles[7][col][0] = tileDeck.deal();
                tiles[7][col][0].setCoordinates(7, col, 0);
                positionTile(tiles[7][col][0], 7, col, 0);
            }
            for (int col = 3; col < 11; col++) {
                tiles[6][col][0] = tileDeck.deal();
                tiles[6][col][0].setCoordinates(6, col, 0);
                positionTile(tiles[6][col][0], 6, col, 0);
            }
            for (int col = 2; col < 12; col++) {
                tiles[5][col][0] = tileDeck.deal();
                tiles[5][col][0].setCoordinates(5, col, 0);
                positionTile(tiles[5][col][0], 5, col, 0);
            }
            tiles[4][0][0] = tileDeck.deal();
            tiles[4][0][0].setCoordinates(4, 0, 0);
            positionTile(tiles[4][0][0], 4, 0, 0);
            for (int col = 1; col < 13; col++) {
                for (int row = 4; row > 2; row--) {
                    tiles[row][col][0] = tileDeck.deal();
                    tiles[row][col][0].setCoordinates(row, col, 0);
                    positionTile(tiles[row][col][0], row, col, 0);
                }
            }
            for (int col = 13; col < 15; col++) {
                tiles[3][col][0] = tileDeck.deal();
                tiles[3][col][0].setCoordinates(3, col, 0);
                positionTile(tiles[3][col][0], 3, col, 0);
            }
            for (int col = 2; col < 12; col++) {
                tiles[2][col][0] = tileDeck.deal();
                tiles[2][col][0].setCoordinates(2, col, 0);
                positionTile(tiles[2][col][0], 2, col, 0);
            }
            for (int col = 3; col < 11; col++) {
                tiles[1][col][0] = tileDeck.deal();
                tiles[1][col][0].setCoordinates(1, col, 0);
                positionTile(tiles[1][col][0], 1, col, 0);
            }
            for (int col = 1; col < 13; col++) {
                tiles[0][col][0] = tileDeck.deal();
                tiles[0][col][0].setCoordinates(0, col, 0);
                positionTile(tiles[0][col][0], 0, col, 0);
            }

        }

        /**
         * Method draws tiles bases on their position/coordinates
         *
         * @param t
         * @param row
         * @param col
         * @param layer
         */
        private void positionTile(Tile t, int row, int col, int layer) {

            int x;
            int y;

            x = (col * 60) + (layer * 15);
            y = (row * 60) - (layer * 15);

            if (row == 4 && col == 7 && layer == 4) {
                y -= 30;
                x -= 30;
            }

            if (row == 4 && col == 0) {
                y -= 30;
            }
            if (row == 3 && (col == 13 || col == 14)) {
                y += 30;
            }
            x += 10;
            y += 10;

            t.setLocation(x, y);
            t.addMouseListener(this);
            add(t);
            t.setZOrder(getComponentZOrder(t));
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            Tile tile = (Tile) e.getSource();
            System.out.println(tile.toString() + " [" + tile.x + "," + tile.y + "," + tile.z + "] Z Order: " + tile.getZOrder());
            /**tiles[tile.x][tile.y][tile.z] = null;
             tile.removeMouseListener(this);
             this.remove(tile);
             revalidate();
             repaint();**/

            if (e.getButton() == MouseEvent.BUTTON1) {

                if (isTileOpen(tile)) {
                    // No previously selected tile - select it
                    if (selected == null) {
                        selected = tile;
                        selected.highlight = true;
                        selected.repaint();
                    }
                    //Doesn't match with another tile or it matched with itself, deselect our selected
                    else if (!(selected.matches(tile)) || (selected.x == tile.x && selected.y == tile.y && selected.z == tile.z)) {
                        selected.highlight = false;
                        selected.repaint();
                        selected = null;
                    }
                    //Matches with another tile that is not itself - Delete both of them
                    else if (selected.matches(tile) && !(selected.x == tile.x && selected.y == tile.y && selected.z == tile.z)) {

                        //Removed the highlight, and removes the action listeners
                        selected.highlight = false;
                        tile.highlight = false;
                        selected.removeMouseListener(this);
                        tile.removeMouseListener(this);

                        //Adds the tiles to the bottom pane
                        removedTiles.addToUndo(selected, tile);

                        //Sets the locations of those tiles to null - no tiles exist in that location
                        tiles[selected.x][selected.y][selected.z] = null;
                        tiles[tile.x][tile.y][tile.z] = null;

                        //Removes the tiles from the board
                        this.remove(selected);
                        this.remove(tile);

                        //No tile is selected anymore
                        selected = null;

                        //If there are 144 tiles in the bottom pane, it means the board is empty and the user won
                        /*if (removedTiles.undoStack.size() != 144) {
                            if (soundOn)
                                stoneSound.play();
                        } else {
                            revalidate();
                            repaint();
                            startReward();
                        }*/

                    }

                    //Really gross way of highlighting all potential matches so it's easy to find tiles
                    for (int row = 0; row < xSize; row++) {
                        for (int col = 0; col < ySize; col++) {
                            for (int layer = 0; layer < layerSize; layer++) {
                                if (tiles[row][col][layer] != null) {
                                    if (selected != null) {
                                        if (tiles[row][col][layer].matches(selected))
                                            tiles[row][col][layer].highlight = true;
                                        else
                                            tiles[row][col][layer].highlight = false;
                                    } else {
                                        tiles[row][col][layer].highlight = false;
                                    }
                                }
                            }
                        }
                    }

                    revalidate();
                    repaint();
                }

            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        /**
         * Checks if a Tile is open based if it has a tile on top of it or on it's
         * left or right side
         *
         * @param t
         * @return true
         */
        private boolean isTileOpen(Tile t) {
            if (t.z == 4 || t.y == 0 || t.y == 14) {
                return true;
            }
            if (t.z == 3 && (tiles[4][7][4] != null)) {
                return false;
            }
            if (t.x == 3 && t.y == 1 && t.z == 0 && (tiles[4][0][0] != null)) {
                return false;
            }
            if (t.x == 4 && t.y == 12 && t.z == 0 && (tiles[3][13][0] != null)) {
                return false;
            }
            return ((tiles[t.x][t.y][t.z + 1] == null) && ((tiles[t.x][t.y - 1][t.z] == null) || (tiles[t.x][t.y + 1][t.z] == null)));
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            Color yellow = new Color(255, 225, 139);
            g2d.setColor(yellow);

            int[] x = {0, 0, 960, 960};
            int[] y = {0, 530, 530, 0};
            Polygon background = new Polygon(x, y, 4);
            g2d.fill(background);

            URL url = Tile.class.getResource("images/dragonz.png");
            backgroundImage = Toolkit.getDefaultToolkit().getImage(url);
            g.drawImage(backgroundImage, 250, 40, this);
        }

    }

    //Creates the bottom pane where removed tiles go
    private void createBottomPane() {
        this.setLayout(new BorderLayout());
        this.add(removedTiles, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int num = rand.nextInt(1000) + 1;
        new Model(num);
    }

}