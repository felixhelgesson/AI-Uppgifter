using Microsoft.Xna.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DT_Game
{
    class Constants
    {
        public static float speed = 1.8f;
        public static Random rnd = new Random();
        public static Vector2 GetRandomPos()
        {
            Vector2 randPos = new Vector2(rnd.Next(100, 1400), rnd.Next(100, 900));
            return randPos;
        }
    }
}
