using DT_Game.DTree;
using DT_Game.DTree.States;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DT_Game
{
    class GameManager
    {
        //Player------------------------------------
        Player p;
        //------------------------------------------

        //Orb---------------------------------------
        Orb orb;
        AimControl aC;
        //------------------------------------------

        //Enemy---------------------------------------
        StandardEnemy stEnemy1;
        StandardEnemy stEnemy2;
        DTenemy dtEnemy;
        //------------------------------------------

        //AI----------------------------------------
        FuSMachine fuSM;
        DTController dtController;
        //------------------------------------------

        //States------------------------------------------------
        GuardState gS;
        ChaseState cS;
        ScoreState sS;

        Tree tree;
        //---------------------------------------------------


        Goal eGoal, pGoal;

        TexManager tM;
        Rectangle hitBoxes;

        public GameManager(TexManager tM)
        {
            this.tM = tM;
            LoadGame();
            hitBoxes = new Rectangle(0, 0, 0, 0);
        }
        void LoadGame()
        {
            //Goals---------------------------------------------
            eGoal = new Goal(new Vector2(1, 450));
            pGoal = new Goal(new Vector2(1500, 450));
            //--------------------------------------------------
            //Player--------------------------------------------
            p = new Player(tM.getTexture(1), Constants.GetRandomPos(), hitBoxes, tM, eGoal);
            p.Init();
            //--------------------------------------------------

            //Enemy---------------------------------------------
            stEnemy1 = new StandardEnemy(tM.getTexture(3), new Vector2(50, 450), hitBoxes, tM, pGoal, Color.Red);
            stEnemy1.Init();
            stEnemy2 = new StandardEnemy(tM.getTexture(3), Constants.GetRandomPos(), hitBoxes, tM, pGoal, Color.Blue);
            stEnemy2.Init();

            //--------------------------------------------------

            //DecisionTree Enemy-----------------------------------------
            dtEnemy = new DTenemy(tM.getTexture(3), new Vector2(50, 450), hitBoxes, tM, pGoal, Color.Purple);
            //------------------------------------------------------------
           
            //Orb-----------------------------------------------
            aC = new AimControl(tM.getTexture(5), Vector2.Zero, p);
            orb = new Orb(tM.getTexture(4), Constants.GetRandomPos(), hitBoxes, Color.Red, 0.1f, p, stEnemy1, stEnemy2, dtEnemy, aC);
            orb.Init();

            //--------------------------------------------------


            //FuSM----------------------------------------------
            //fuSM = new FuSMachine(p, orb, stEnemy1, stEnemy2, eGoal, pGoal);
            //--------------------------------------------------

            //States---------------------------------------
            gS = new GuardState(dtEnemy, orb, pGoal, eGoal);
            cS = new ChaseState(dtEnemy, orb, pGoal, eGoal);
            sS = new ScoreState(dtEnemy, orb, pGoal, eGoal);
            //--------------------------------------------------

            dtController = new DTController(dtEnemy, orb, tree, cS, gS, sS, pGoal, eGoal);

        }


        public void Update(GameTime gT)
        {
            p.Update(gT);
            stEnemy1.Update(gT);
            stEnemy2.Update(gT);
            orb.Update(gT);
            dtEnemy.Update(gT);
            dtController.Update(gT);
            //fuSM.Update(gT);
        }

        public void Draw(SpriteBatch sB)
        {
            sB.Draw(tM.getTexture(0), Vector2.Zero, Color.White);
            //stEnemy1.Draw(sB);
            //stEnemy2.Draw(sB);
            p.Draw(sB);
            orb.Draw(sB);
            dtEnemy.Draw(sB);


        }
    }
}
