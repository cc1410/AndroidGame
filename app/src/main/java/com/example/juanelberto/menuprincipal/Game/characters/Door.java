package com.example.juanelberto.menuprincipal.Game.characters;

import com.example.juanelberto.menuprincipal.Game.GameEngine;



/**
 * Created by chen on 26/04/2018.
 */

public class Door extends Character {
    public Door(GameEngine gameEngine, int x, int y) {
        super(gameEngine, x, y);
        this.sprite = 0;
    }
    private static final int[][] ANIMATIONS = new int[][]{
            new int[]{54}
    };

    @Override
    int[][] getAnimations() {
        return ANIMATIONS;
    }

    @Override
    void updatePhysics(int delta) {

    }

    @Override
    void updateCollisionRect() {
        collisionRect.set(x, y, x + 32, y + 32);
    }
}
