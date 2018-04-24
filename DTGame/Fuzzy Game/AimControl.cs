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
    class AimControl
    {
        Texture2D tex;
        Vector2 pos;
        Player p;

        Vector2 aimSpeed = new Vector2(2.5f, 2.5f);

        bool aiming = false;

        KeyboardState kS;

        public AimControl(Texture2D tex, Vector2 pos, Player p)
        {
            this.tex = tex;
            this.pos = pos;
            this.p = p;
            kS = new KeyboardState();
        }
        public void UpdateAimDirection()
        {
            if (kS.IsKeyDown(Keys.Up))
            {
                pos.Y -= 1;
            }
            if (kS.IsKeyDown(Keys.Down))
            {
                pos.Y += 1;
            }
            if (kS.IsKeyDown(Keys.Left))
            {
                pos.X -= 1;
            }
            if (kS.IsKeyDown(Keys.Right))
            {
                pos.X += 1;
            }

        }

        public Vector2 NormDirection()
        {
            if (pos == Vector2.Zero)
                return Vector2.Zero;
            return Vector2.Normalize(pos - p.GetPlayerPos);
        }

        public static float ToAngle(Vector2 vector)
        {
            return (float)Math.Atan2(vector.Y, vector.X);
        }

        public Vector2 setPos
        {
            set { pos = value; }
        }

        public void DrawArrow(SpriteBatch sB)
        {
            sB.Draw(tex, p.GetPlayerPos, null, Color.White, (float)Math.PI * ToAngle(pos) / 180, new Vector2(tex.Width / 2 + tex.Width, tex.Height / 2 + tex.Height), 1, SpriteEffects.None, 0);
        }

    }
}
