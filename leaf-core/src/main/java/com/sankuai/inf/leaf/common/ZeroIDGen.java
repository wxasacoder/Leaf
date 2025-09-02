package com.sankuai.inf.leaf.common;

import com.sankuai.inf.leaf.IDGen;

public class ZeroIDGen implements IDGen {
    @Override
    public IdResult get(String key) {
        return new IdResult(0, Status.SUCCESS);
    }

    @Override
    public boolean init() {
        return true;
    }
}
