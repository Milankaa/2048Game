package pkg2048game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import static java.lang.String.valueOf;
import java.util.Random;

public class TilePanel extends javax.swing.JPanel {

    Font font = new Font("Arial", Font.BOLD, 45);
    int TILE_SIZE = 100;
    Tile[][] FilledTiles = new Tile[4][4];
    Random r1 = new Random();
    int x = r1.nextInt(4);
    int y = r1.nextInt(4);

    public TilePanel() {

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NewGameButton = new javax.swing.JButton();
        ScoreLabel = new javax.swing.JLabel();
        BestScoreLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(450, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("2048");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText(" Join the numbers and get to the 2048 tile!");

        NewGameButton.setBackground(new java.awt.Color(204, 204, 204));
        NewGameButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        NewGameButton.setText("New Game");
        NewGameButton.setToolTipText("");
        NewGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameButtonActionPerformed(evt);
            }
        });

        ScoreLabel.setBackground(new java.awt.Color(204, 204, 204));
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
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NewGameButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BestScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(ScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BestScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NewGameButton)))
                .addContainerGap(472, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NewGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameButtonActionPerformed

    }//GEN-LAST:event_NewGameButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BestScoreLabel;
    private javax.swing.JButton NewGameButton;
    private javax.swing.JLabel ScoreLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    private int TextWidth(String s) {
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        int w = (int) (font.getStringBounds(s, frc).getWidth());
        return w;
    }

    private int TextHeight(String s) {
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        int h = (int) (font.getStringBounds(s, frc).getHeight());
        return h;
    }

    private void newGame() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                FilledTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        FilledTiles[x][y].TileValue = startValue();
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
        return 25 + x * 105;
    }

    private static int positionY(int y) {
        return 155 + y * 105;
    }

    private void drawTile(Graphics g2, Tile tile, int x, int y) {
        Graphics2D g = ((Graphics2D) g2);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        int value = tile.TileValue;
        int POSITION_X = positionX(x);
        int POSITION_Y = positionY(y);

        String s = valueOf(value);
        int w = TextWidth(s);
        int h = TextHeight(s);

        g.setFont(font);
        g.setColor(tile.TileBackground(value));
        g.fillRect(POSITION_X, POSITION_Y, TILE_SIZE, TILE_SIZE);
        g.setColor(tile.TileValueColor());
        if (value != 0) {
            g.drawString(String.valueOf(value), POSITION_X + (TILE_SIZE - w) / 2, POSITION_Y + (TILE_SIZE + h) / 2 - 8);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        newGame();
        g.setColor(Color.LIGHT_GRAY);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                g.fillRoundRect(positionX(i), positionY(j), TILE_SIZE, TILE_SIZE, 15, 15);
                if (FilledTiles[i][j].TileValue != 0) {
                    drawTile(g, FilledTiles[i][j], i, j);
                }
            }
        }
    }
}
