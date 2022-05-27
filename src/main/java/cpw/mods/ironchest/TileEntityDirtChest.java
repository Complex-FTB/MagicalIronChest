package cpw.mods.ironchest;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.StatCollector;

public class TileEntityDirtChest extends TileEntityIronChest {
    private static ItemStack dirtChestGuideBook = new ItemStack(Items.written_book);
    static {
        dirtChestGuideBook.setTagInfo("author", new NBTTagString("cpw"));
        dirtChestGuideBook.setTagInfo("title", new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest.title")));
        NBTTagList pages = new NBTTagList();
        pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest.page1")));
        pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest.page2")));
        pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest.page3")));
        pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest.page4")));
        pages.appendTag(new NBTTagString(StatCollector.translateToLocal("book.ironchest:dirtchest.page5")));
        dirtChestGuideBook.setTagInfo("pages", pages);
    }
    public TileEntityDirtChest() {
        super(IronChestType.DIRTCHEST);
    }

    @Override
    public void wasPlaced(EntityLivingBase entityliving, ItemStack itemStack)
    {
        if (!(itemStack.hasTagCompound() && itemStack.getTagCompound().getBoolean("dirtchest"))) {
            setInventorySlotContents(0, dirtChestGuideBook.copy());
        }
    }

    @Override
    public void removeAdornments()
    {
        if (chestContents[0] != null && chestContents[0].isItemEqual(dirtChestGuideBook)) {
            chestContents[0] = null;
        }
    }
}
