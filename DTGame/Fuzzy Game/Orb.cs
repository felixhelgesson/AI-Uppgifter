using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace DT_Game
{
    class Orb : GameObject
    {
        //Objects---------------------------------
        Player p;
        StandardEnemy e;
        StandardEnemy e2;
        StandardEnemy[] enemies;
        AimControl aC;
        //----------------------------------------
        //Misc------------------------------------
        Texture2D tex;
        Vector2 pos, dir;
        Color c;
        Rectangle hitBox;
        KeyboardState kS;

        float rotation;
        Vector2 position;
        float speed;
        Vector2 mousePos;
        //----------------------------------------
        //Variables-------------------------------
        float size;
        bool haveBall = false;
        bool enemyHaveBall = false;
        Vector2 origin;
        float timer = 0;
        int pxToUnit = 1000;
        //----------------------------------------
        //Weight--------------------------------------
        float dTB; // Distance to Ball
        //----------------------------------------------

        public Orb(Texture2D tex, Vector2 pos, Rectangle hitBox, Color c, float size, Player p, StandardEnemy enemy, StandardEnemy enemy2, AimControl aC) : base(tex, pos, hitBox)
        {
            //Declarations--------------------
            this.tex = tex;
            this.pos = pos;
            this.size = size;
            this.c = c;
            this.hitBox = hitBox;
            this.p = p;
            this.aC = aC;
            e = enemy;
            e2 = enemy2;
            //--------------------------------
        }



        public void Init()
        {
            hitBox = new Rectangle(0, 0, 19, 19);
            kS = new KeyboardState();
            aC.setPos = p.GetPlayerPos;
            dir = new Vector2(0, 0);
            enemies = new StandardEnemy[] { e, e2 };

        }
        public override void Update(GameTime gT)
        {
            timer++;
            hitBox.X = (int)pos.X;
            hitBox.Y = (int)pos.Y;
            origin = pos / 2;

            if (hitBox.Intersects(p.getHitBox))
            {
                haveBall = true;
                enemyHaveBall = false;
            }

            if (haveBall)
            {
                pos.X = p.GetPlayerPos.X + 12;
                pos.Y = p.GetPlayerPos.Y - 30;

                if (p.getHitBox.Intersects(e.getHitbox))
                {
                    if (p.GetAiming == false)
                    {
                        if (timer > 200)
                        {
                            enemyHaveBall = true;
                            haveBall = false;
                            timer = 0;
                        }

                    }
                }
                if (p.GetAiming == true)
                {

                    MouseState mouse = Mouse.GetState();
                    pos.X = mouse.X;
                    pos.Y = mouse.Y;
                }
            }
            if (enemyHaveBall)
            {
                pos.X = e.GetEnemyPos.X + 12;
                pos.Y = e.GetEnemyPos.Y - 30;

                if (p.getHitBox.Intersects(e.getHitbox))
                {
                    if (timer > 200)
                    {
                        PlayerHaveBall = true;
                        enemyHaveBall = false;
                        timer = 0;
                    }
                }
            }
            UpdateWeight();
        }

        public void MadeGoal()
        {
            //todo: Keep score
            pos = Constants.GetRandomPos();
        }

        void UpdateWeight()
        {
            dTB = Vector2.Distance(pos, e.GetEnemyPos);
        }

        public static float Angle(Vector2 from, Vector2 to)
        {
            return (float)Math.Atan2(from.X - to.X, to.Y - from.Y);
        }
        void Shoot()
        {
        }
        public override void Draw(SpriteBatch sb)
        {
            //base.Draw(sb);
            sb.Draw(tex, pos, Color.White);
            if (p.GetAiming == true)
            {
                sb.Draw(tex, pos, Color.White);
            }
            //sb.Draw(TexManager.onepix, hitBox, Color.Red);
        }
        public Vector2 SetPos
        {
            set { pos += value; }
        }

        public Vector2 getPos
        {
            get { return pos; }
        }

        public float GetDistanceToBall
        {
            get { return dTB / pxToUnit; }
        }


        //Have Ball-Properties

        public bool PlayerHaveBall
        {
            get { return haveBall; }
            set { haveBall = value; }
        }
        public bool EnemyHaveBall
        {
            get { return enemyHaveBall; }
            set { enemyHaveBall = value; }
        }


    }
}
