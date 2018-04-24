using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Content;
using Microsoft.Xna.Framework.Input;

namespace DT_Game
{
    class TexManager
    {
        
        ContentManager cM;
        Texture2D[] texArray;
        public static Texture2D onepix;
        public static Texture2D arrow;

        public TexManager(ContentManager cM)
        {
            this.cM = cM;
            texArray = new Texture2D[10];
            LoadTextures();
        }

        void LoadTextures()
        {
            texArray[0] = cM.Load<Texture2D>("background");
            texArray[1] = cM.Load<Texture2D>("player");
            texArray[2] = cM.Load<Texture2D>("shadow");
            texArray[3] = cM.Load<Texture2D>("player");
            texArray[4] = cM.Load<Texture2D>("orb");
            texArray[5] = cM.Load<Texture2D>("goalie");


            arrow = cM.Load<Texture2D>("arrow");
            onepix = cM.Load<Texture2D>("hitboxtest");
            

            
        }
        /// <summary>
        /// Gets a specified texture.
        /// </summary>
        /// <param name="index">The nr of the texture : 0 = background, 1 = player, 2 = shadow, 3 = enemy, 4 = orb </param>
        /// <returns></returns>
        public Texture2D getTexture(int index)
        {
            return texArray[index];
        }
    }
}
