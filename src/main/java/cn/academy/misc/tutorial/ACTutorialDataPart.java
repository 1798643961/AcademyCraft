package cn.academy.misc.tutorial;

import java.util.BitSet;

import cn.annoreg.core.Registrant;
import cn.liutils.registry.RegDataPart;
import cn.liutils.util.helper.DataPart;
import net.minecraft.nbt.NBTTagCompound;
@Registrant
@RegDataPart("tutorialStatus")
public class ACTutorialDataPart extends DataPart {
	public BitSet tutorialStatusSet=new BitSet(ACTutorialUtils.TUTORIAL_NUM);
	public ACTutorialDataPart(){
		initSet();
	}
	
	private void initSet(){
		tutorialStatusSet.clear();
		for(ACTutorial t:ACTutorialList.list){
			tutorialStatusSet.set(t.id, t.isLoaded);
		}
	}
	
	@Override
	public void fromNBT(NBTTagCompound tag) {
		// TODO Auto-generated method stub
		for(int i=0;i<ACTutorialUtils.TUTORIAL_NUM;i++){
			try{
				tutorialStatusSet.set(i, tag.getBoolean(String.valueOf(i)));
			}catch(Exception e){
				//��Ҳ��֪������᲻�ᱬը
				e.printStackTrace();
			}
		}
	}

	@Override
	public NBTTagCompound toNBT() {
		// TODO Auto-generated method stub
		NBTTagCompound tag=new NBTTagCompound();
		for(int i=0;i<ACTutorialUtils.TUTORIAL_NUM;i++){
			tag.setBoolean(String.valueOf(i), Boolean.valueOf(tutorialStatusSet.get(i)));
		}
		return tag;
	}
	
	void updateTutorialStatus(ACTutorial tutorial,boolean isLoaded){
		tutorialStatusSet.set(tutorial.id, isLoaded);
		//��ȷ���Ƿ���Ҫ�ֶ�����ͬ��
		//fireEvents();
		this.sync();
	}
	boolean getTutorialStatus(ACTutorial tutorial){
		return this.tutorialStatusSet.get(tutorial.id);
	}
	
}
