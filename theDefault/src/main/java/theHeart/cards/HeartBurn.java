package theHeart.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import theHeart.DefaultMod;
import theHeart.characters.TheDefault;

import static theHeart.DefaultMod.makeCardPath;

public class HeartBurn extends AbstractDynamicCard {
    public static final String ID = DefaultMod.makeID(HeartBurn.class.getSimpleName());
    public static final String IMG = makeCardPath("Skill.png");

    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    // /TEXT DECLARATION/


    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;


    private static final int UPGRADE_PLUS_MAGIC_NUMBER = 3;
    private static final int MAGIC_NUMBER = 11;
    private static final int DEFAULTSECONDMAGICNUMBER = 4;
    private static final int UPGRADE_PLUS_DEFAULTSECONDMAGICNUMBER = -1;

    // /STAT DECLARATION/


    public HeartBurn() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
magicNumber = MAGIC_NUMBER;
defaultSecondMagicNumber =  DEFAULTSECONDMAGICNUMBER;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

         AbstractDungeon.actionManager.addToBottom
                 (new ApplyPowerAction(m, p, new PoisonPower(m, p, this.magicNumber), this.magicNumber, AbstractGameAction.AttackEffect.POISON));
         AbstractDungeon.actionManager.addToBottom
                 (new ApplyPowerAction (p, p, new PoisonPower(p, p, this.defaultSecondMagicNumber), this.defaultSecondMagicNumber));

        }



    //Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(UPGRADE_PLUS_MAGIC_NUMBER);
            upgradeDefaultSecondMagicNumber(UPGRADE_PLUS_DEFAULTSECONDMAGICNUMBER);
            rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }

}