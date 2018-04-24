using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DT_Game
{
    abstract class GameObject
    {

        Texture2D tex;
        Vector2 pos;
        Rectangle hitBox;

        public GameObject(Texture2D tex, Vector2 pos, Rectangle hitBox)
        {
            this.tex = tex;
            this.pos = pos;
            this.hitBox = hitBox;

        }

        public abstract void Update(GameTime gT);


        public virtual void Draw(SpriteBatch sb)
        {
            sb.Draw(tex, pos, Color.White);
        }

        public Vector2 GetPos
        {
            get { return pos; }
        }

    }
}
