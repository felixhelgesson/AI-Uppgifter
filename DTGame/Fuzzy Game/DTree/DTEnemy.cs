    using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;
using DT_Game.DTree.States;

namespace DT_Game.DTree
{
    class DTenemy : GameObject
    {
        //Textures and Vectors---------------------
        Texture2D tex;
        Texture2D shadow;
        Vector2 pos;
        Vector2 vel;
        //----------------------------------------

        //Variables-------------------------------
        float speed = 6.5f;
        int pxToUnit = 1000;
        bool goalReady = false;
        //----------------------------------------

        //Objects------------------------------------
        KeyboardState kS;
        TexManager tM;
        //-------------------------------------------

        //Weights-----------------------------------
        float dTG; // Distance to Goal.
        //-------------------------------------------

        //Misc---------------------------------------
        Rectangle hitBox;
        Color c;
        //-------------------------------------------
    

        Goal pGoal;

        public DTenemy(Texture2D tex, Vector2 pos, Rectangle hitBox, TexManager tM, Goal pGoal, Color c) : base(tex, pos, hitBox)
        {
            this.tex = tex;
            this.pos = pos;
            this.tM = tM;
            this.hitBox = hitBox;
            this.pGoal = pGoal;
            this.c = c;
            vel = new Vector2(0, 0);
        }
        public void Init()
        {
            shadow = tM.getTexture(2);
            hitBox = new Rectangle(0, 0, 48, 107);
        }
        public override void Update(GameTime gT)
        {
            dTG = Vector2.Distance(pos, pGoal.GetGoalPos);
        }
        public override void Draw(SpriteBatch sb)
        {
            //sb.Draw(shadow, new Vector2(pos.X - 415, pos.Y + 295), Color.White);
            sb.Draw(tex, pos, c);
            //sb.Draw(TexManager.onepix, hitBox, Color.Blue);
        }



        public Rectangle getHitbox
        {
            get { return hitBox; }
        }

        public int getHitBoxX
        {
            get { return hitBox.X; }
            set { hitBox.X = value; }
        }
        public int getHitBoxY
        {
            get { return hitBox.Y; }
            set { hitBox.Y = value; }
        }
        public Vector2 GetEnemyPos
        {
            get { return pos; }
            set { pos = value; }
        }

        public float GetDistanceToGoal
        {
            get { return dTG / pxToUnit; }
        }
        public bool GoalReady
        {
            get { return goalReady; }
            set { goalReady = value; }
        }
    }
}
