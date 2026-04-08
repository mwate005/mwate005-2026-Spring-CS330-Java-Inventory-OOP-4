package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Armour;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ArmourCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ArmourCreation construct()
    {
        return new ArmourCreation();
    }

    @Override
    public Item fromDefaults()
    {
        // Maybe call a Default Constructor...
        return new Armour();
    }

    @Override
    public int requiredNumberOfValues()
    {
        // What is the correct return value?
        return 7;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {

        Armour armour = new Armour();

        armour.setName(tokens[1]);
        armour.setMaterial(tokens[2]);
        armour.setDurability(Integer.parseInt(tokens[3]));
        armour.setDefense(Integer.parseInt(tokens[4]));
        armour.setModifier(tokens[5]);
        armour.setModifierLevel(Integer.parseInt(tokens[6]));
        armour.setElement(tokens[7]);

        return armour;
    }

    @Override
    public Item fromExisting(final Item original)
    {
        return original.clone();
    }
}
