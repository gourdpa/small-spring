package cn.gourdpa.springframework.beans;

import cn.gourdpa.springframework.beans.ProperValue;

import java.util.ArrayList;
import java.util.List;

public class ProperValues {
    private List<ProperValue> properValueList = new ArrayList<>();

    public void addProperValue(ProperValue properValue) {
        this.properValueList.add(properValue);
    }

    public ProperValue[] getProperValues(){
        return this.properValueList.toArray(new ProperValue[0]);
    }

    public ProperValue getProperValue(String propertyName){
        for (ProperValue properValue:this.properValueList) {
            if (properValue.getName().equals(properValue)) {
                return properValue;
            }
        }
        return null;
    }
}
