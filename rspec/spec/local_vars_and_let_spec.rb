var = p :var
describe :top do
  foo = p :foo
  let(:lazy) { p :lazy }
  let!(:eager) { p :eager }
  describe :sub do
    bar = p :bar
    it do
      expect(var).to eq :var
      expect(foo).to eq :foo
      expect(bar).to eq :bar
      expect(lazy).to eq :lazy
      expect(eager).to eq :eager
    end
  end

  it do
    expect(var).to eq :var
    expect(foo).to eq :foo
    expect(lazy).to eq :lazy
    expect(eager).to eq :eager
  end
end
