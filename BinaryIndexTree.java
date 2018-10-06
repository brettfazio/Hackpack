class BIT
	{
		long[] tree;
		int n;
		BIT(int n)
		{
			tree = new long[n+1];
			this.n = n;
		}
		void upd(int x, int v)
		{
			int i = x;
			while(i<=n)
			{
				tree[i]+=v;
				i += (i&-i);
			}
		}
		long csum(int x)
		{
			long s = 0;
			while(x>0)
			{
				s += tree[x];
				x -= (x&-x);
			}
			return s;
		}
		long csum(int x, int y)
		{
			return csum(y) - csum(x-1);
		}
	}
