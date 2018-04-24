using Microsoft.Xna.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DT_Game
{
    class Score
    {
        List<int> pGoals, eGoals;

        public Score()
        {
            pGoals = new List<int>();
            eGoals = new List<int>();
        }

        public void AddGoals(int scorer)
        {
            if (scorer == 1)
            {
                pGoals.Add(scorer);
            }
            else if (scorer == 2)
            {
                eGoals.Add(scorer);
            }
        }

        public int GetPlayerGoals
        {
            get { return pGoals.Count; }
        }

        public int GetEnemyGoals
        {
            get { return eGoals.Count; }
        }

    }




}

