using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DT_Game
{
    class Player : GameObject
    {
        //Textures and Vectors---------------------
        Texture2D tex;
        Texture2D shadow;
        Vector2 pos;
        Vector2 vel;
        //----------------------------------------

        //Variables-------------------------------
        float speed = 6.5f;
        bool aiming = false;
        //----------------------------------------

        //Objects------------------------------------
        KeyboardState kS;
        TexManager tM;
        //-------------------------------------------

        //Misc---------------------------------------
        Rectangle hitBox;
        //-------------------------------------------

        Goal eGoal;

        public Player(Texture2D tex, Vector2 pos, Rectangle hitBox, TexManager tM, Goal eGoal) : base(tex, pos, hitBox)
        {
            this.tex = tex;
            this.pos = pos;
            this.tM = tM;
            this.hitBox = hitBox;
            vel = new Vector2(0, 0);
            this.eGoal = eGoal;
        }
        public void Init()
        {
            shadow = tM.getTexture(2);
            hitBox = new Rectangle(0, 0, 48, 107);
        }
        public override void Update(GameTime gT)
        {
            kS = Keyboard.GetState();
            vel.X = 0;
            vel.Y = 0;

            if (kS.IsKeyDown(Keys.A))
            {
                vel.X = -speed;
            }
            else if (kS.IsKeyDown(Keys.D))
            {
                vel.X = speed;
            }
            else if (kS.IsKeyDown(Keys.W))
            {
                vel.Y = -speed;
            }
            else if (kS.IsKeyDown(Keys.S))
            {
                vel.Y = speed;
            }

            if (kS.IsKeyDown(Keys.Space))
            {
                aiming = true;
            }
            else
                aiming = false;

            pos += vel;
            hitBox.X = (int)pos.X;
            hitBox.Y = (int)pos.Y;
        }
        public override void Draw(SpriteBatch sb)
        {
            //sb.Draw(shadow, new Vector2(pos.X - 415, pos.Y + 295), Color.White);
            sb.Draw(tex, pos, Color.White);
            //sb.Draw(TexManager.onepix, hitBox, Color.Green);
        }

        public Rectangle getHitBox
        {
            get { return hitBox; }
        }
        public Vector2 GetPlayerPos
        {
            get { return pos; }
        }
        public bool GetAiming
        {
            get { return aiming; }
        }
    }
}
