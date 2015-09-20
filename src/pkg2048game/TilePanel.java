package pkg2048game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import static java.lang.String.valueOf;
import java.util.Random;

public class TilePanel extends javax.swing.JPanel implements KeyListener {

    int COL = 4;
    int ROW = 4;
    int PANEL_WIDTH = 450;
    int PANEL_HEIGHT = 600;
    Font FONT = new Font("Arial", Font.BOLD, 45);
    static final int TILE_SIZE = 100;
    Tile[][] Tiles = new Tile[COL][ROW];
    boolean TileMoved = false;
    private int SCORE = 0;
    private int BESTSCORE;
    boolean YouWon = false;
    boolean YouLost = false;
    private int TARGET = 2048;
    boolean canMove;

    public TilePanel() {
        setFocusable(true);
        addKeyListener(this);
        initComponents();
        newGame();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NewGameButton = new javax.swing.JButton();
        ScoreLabel = new javax.swing.JLabel();
        BestScoreLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 72));
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("2048");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText(" Join the numbers and get to the 2048 tile! ");

        NewGameButton.setBackground(new java.awt.Color(210, 235, 90));
        NewGameButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        NewGameButton.setText("New Game");
        NewGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameButtonActionPerformed(evt);
            }
        });

        ScoreLabel.setBackground(new java.awt.Color(255, 255, 0));
        ScoreLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ScoreLabel.setText(" SCORE : ");
        ScoreLabel.setToolTipText("");
        ScoreLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ScoreLabel.setPreferredSize(new java.awt.Dimension(67, 30));

        BestScoreLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BestScoreLabel.setText(" BEST SCORE : ");
        BestScoreLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NewGameButton))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(BestScoreLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ScoreLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BestScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NewGameButton)
                                .addComponent(jLabel2))
                        .addContainerGap(481, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NewGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        newGame();
        this.grabFocus();
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BestScoreLabel;
    private javax.swing.JButton NewGameButton;
    private javax.swing.JLabel ScoreLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    private int textWidth(String s, Tile tile) {
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        int w = (int) (tile.TileValueFont().getStringBounds(s, frc).getWidth());
        return w;
    }

    private int textHeight(String s, Tile tile) {
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        int h = (int) (tile.TileValueFont().getStringBounds(s, frc).getHeight());
        return h;
    }

    public int messageWidth(String s) {
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        int w = (int) (FONT.getStringBounds(s, frc).getWidth());
        return w;
    }

    private int messageHeight(String s) {
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        int h = (int) (FONT.getStringBounds(s, frc).getHeight());
        return h;
    }

    private void newGame() {
        canMove = true;
        YouWon = false;
        YouLost = false;
        SCORE = 0;
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                Tiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        int num = startValue();
        int x;
        int y;
        Random r1 = new Random();
        do {
            x = r1.nextInt(4);
            y = r1.nextInt(4);
        } while (Tiles[x][y].getTileValue() != 0);
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                if (i == x && j == y) {
                    Tiles[i][j].setTileValue(num);
                }
            }
        }
    }

    private int startValue() {
        Random r = new Random();
        int d = r.nextInt(10);
        if (d < 8) {
            return 2;
        } else {
            return 4;
        }
    }

    private static int positionX(int x) {
        return 25 + x * (TILE_SIZE + 5);
    }

    private static int positionY(int y) {
        return 155 + y * (TILE_SIZE + 5);
    }

    private int emptySpace() {
        int a = 0;
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                if (Tiles[i][j].isEmpty()) {
                    a++;
                }
            }
        }
        return a;
    }

    private boolean needAddTile() {
        return emptySpace() > 0;
    }

    private int Score() {
        return SCORE;
    }

    public boolean GameWon() {
        for (int j = 0; j < ROW; j++) {
            for (int i = 0; i < COL; i++) {
                if (Tiles[i][j].getTileValue() == 128) {
                    YouWon = true;
                    canMove = false;

                }
            }
        }
        return YouWon;
    }

    public boolean GameLost() {
        for (int i = 0; i < COL - 1; i++) {
            for (int j = 0; j < ROW - 1; j++) {
                if (emptySpace() == 0
                        && Tiles[i][j].getTileValue() != Tiles[i + 1][j].getTileValue()
                        && Tiles[i][j].getTileValue() != Tiles[i][j + 1].getTileValue()) {
                    canMove = false;
                    YouLost = true;
                }
            }
        }
        return YouLost;
    }

    public void down() {
        TileMoved = false;
        for (int i = 0; i < COL; i++) {
            int d = 0;
            for (int j = ROW - 1; j >= 0; j--) {
                if (Tiles[i][j].isEmpty()) {
                    d++;
                } else if (j < 3) {
                    if (d >= 0 && ROW - j - 1 > d && Tiles[i][j].getTileValue() == Tiles[i][j + d + 1].getTileValue()) {
                        Tiles[i][j + d + 1].setTileValue(2 * Tiles[i][j].getTileValue());
                        SCORE += 2 * Tiles[i][j].getTileValue();
                        Tiles[i][j].setTileValue(0);
                        TileMoved = true;
                        d++;
                    } else if (d > 0 && ROW - j - 1 > d && Tiles[i][j].getTileValue() != Tiles[i][j + d + 1].getTileValue()) {
                        Tiles[i][j + d].setTileValue(Tiles[i][j].getTileValue());
                        Tiles[i][j].setTileValue(0);
                        TileMoved = true;
                    } else if (d > 0 && ROW - j - 1 <= d) {
                        Tiles[i][j + d].setTileValue(Tiles[i][j].getTileValue());
                        Tiles[i][j].setTileValue(0);
                        TileMoved = true;
                    }
                }
            }
        }
    }

    public void up() {
        TileMoved = false;
        for (int i = 0; i < COL; i++) {
            int d = 0;
            for (int j = 0; j < ROW; j++) {
                if (Tiles[i][j].isEmpty()) {
                    d++;
                } else if (j > 0) {
                    if (d >= 0 && j > d && Tiles[i][j].getTileValue() == Tiles[i][j - d - 1].getTileValue()) {
                        Tiles[i][j - d - 1].setTileValue(2 * Tiles[i][j].getTileValue());
                        SCORE += 2 * Tiles[i][j].getTileValue();
                        Tiles[i][j].setTileValue(0);
                        TileMoved = true;
                        d++;
                    } else if (d > 0 && j > d && Tiles[i][j].getTileValue() != Tiles[i][j - d - 1].getTileValue()) {
                        Tiles[i][j - d].setTileValue(Tiles[i][j].getTileValue());
                        Tiles[i][j].setTileValue(0);
                        TileMoved = true;
                    } else if (d > 0 && j == d) {
                        Tiles[i][j - d].setTileValue(Tiles[i][j].getTileValue());
                        Tiles[i][j].setTileValue(0);
                        TileMoved = true;
                    }
                }
            }
        }
    }

    private void right() {
        TileMoved = false;
        for (int j = 0; j < ROW; j++) {
            int d = 0;
            for (int i = COL - 1; i >= 0; i--) {
                if (Tiles[i][j].getTileValue() == 0) {
                    d++;
                } else if (i < 3) {
                    if (d >= 0 && COL - i - 1 > d && Tiles[i][j].getTileValue() == Tiles[i + d + 1][j].getTileValue()) {
                        Tiles[i + d + 1][j].setTileValue(2 * Tiles[i][j].getTileValue());
                        SCORE += 2 * Tiles[i][j].getTileValue();
                        Tiles[i][j].setTileValue(0);
                        TileMoved = true;
                        d++;
                    } else if (d > 0 && COL - i - 1 > d && Tiles[i][j].getTileValue() != Tiles[i + d + 1][j].getTileValue()) {
                        Tiles[i + d][j].setTileValue(Tiles[i][j].getTileValue());
                        Tiles[i][j].setTileValue(0);
                        TileMoved = true;
                    } else if (d > 0 && COL - i - 1 <= d) {
                        Tiles[i + d][j].setTileValue(Tiles[i][j].getTileValue());
                        Tiles[i][j].setTileValue(0);
                        TileMoved = true;
                    }
                }
            }
        }
    }

    private void left() {
        TileMoved = false;
        for (int j = 0; j < ROW; j++) {
            int d = 0;
            for (int i = 0; i < COL; i++) {
                if (Tiles[i][j].getTileValue() == 0) {
                    d++;
                } else if (i > 0) {
                    if (d >= 0 && i > d && Tiles[i][j].getTileValue() == Tiles[i - d - 1][j].getTileValue()) {
                        Tiles[i - d - 1][j].setTileValue(2 * Tiles[i][j].getTileValue());
                        SCORE += 2 * Tiles[i][j].getTileValue();
                        Tiles[i][j].setTileValue(0);
                        TileMoved = true;
                        d++;
                    } else if (d > 0 && i > d && Tiles[i][j].getTileValue() != Tiles[i - d - 1][j].getTileValue()) {
                        Tiles[i - d][j].setTileValue(Tiles[i][j].getTileValue());
                        Tiles[i][j].setTileValue(0);
                        TileMoved = true;
                    } else if (d > 0 && i == d) {
                        Tiles[i - d][j].setTileValue(Tiles[i][j].getTileValue());
                        Tiles[i][j].setTileValue(0);
                        TileMoved = true;
                    }
                }
            }
        }
    }

    private void drawMessage(Graphics g2, String Message) {
        Graphics2D g = ((Graphics2D) g2);

        int w = messageWidth(Message);
        int h = messageHeight(Message);
        g.drawString(Message, (PANEL_WIDTH - w) / 2, (PANEL_HEIGHT + h) / 2);
    }

    private void drawScore(Graphics g, int score) {
        String s = "Your score:" + valueOf(score);
        int w = messageWidth(s);
        int h = messageHeight(s);
        g.drawString(s, (PANEL_WIDTH - w) / 2, PANEL_HEIGHT / 2 + 2 * h);

    }

    private void drawTile(Graphics g2, Tile tile, int x, int y) {
        Graphics2D g = ((Graphics2D) g2);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        int value = tile.getTileValue();
        int POSITION_X = positionX(x);
        int POSITION_Y = positionY(y);

        String s = valueOf(value);
        int w = textWidth(s, tile);
        int h = textHeight(s, tile);

        g.setFont(tile.TileValueFont());
        g.setColor(tile.TileBackground(value));
        g.fillRoundRect(POSITION_X, POSITION_Y, TILE_SIZE, TILE_SIZE, 15, 15);
        g.setColor(tile.TileValueColor());
        g.drawString(String.valueOf(value), POSITION_X + (TILE_SIZE - w) / 2, POSITION_Y + (TILE_SIZE + h) / 2 - 6);
    }

    @Override
    public void paint(Graphics g2) {
        Graphics2D g = ((Graphics2D) g2);
        ScoreLabel.setText(" SCORE: " + valueOf(Score()));
        super.paint(g);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        g.setColor(Color.GRAY);
        g.fillRect(20, 150, 4 * TILE_SIZE + 25, 4 * TILE_SIZE + 25);
        for (int j = 0; j < ROW; j++) {
            for (int i = 0; i < COL; i++) {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRoundRect(positionX(i), positionY(j), TILE_SIZE, TILE_SIZE, 15, 15);
                if (Tiles[i][j].getTileValue() != 0) {
                    drawTile(g, Tiles[i][j], i, j);
                }
            }
        }
        if (GameWon()) {
            canMove = false;
            g.setColor(Color.WHITE);
            g.fillRect(10, 140, 4 * TILE_SIZE + 40, 4 * TILE_SIZE + 40);
            String Message1 = "Congrats!You WON!";
            g.setColor(Color.BLUE);
            drawMessage(g, Message1);
            drawScore(g, SCORE);
        }
        if (GameLost()) {
            canMove = false;
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(10, 140, 4 * TILE_SIZE + 40, 4 * TILE_SIZE + 40);
            String Message1 = "Game over!";
            g.setColor(Color.BLUE);
            drawMessage(g, Message1);
            drawScore(g, SCORE);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (canMove) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                down();
                if (needAddTile() && TileMoved) {
                    addTile();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                up();
                if (needAddTile() && TileMoved) {
                    addTile();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                left();
                if (needAddTile() && TileMoved) {
                    addTile();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                right();
                if (needAddTile() && TileMoved) {
                    addTile();
                }
            }
            repaint();
        }
        System.out.print(canMove);

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
