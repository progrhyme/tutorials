describe 'let' do
  let(:str) { "string" }
  before do
    p str.object_id
  end
  after do
    p str.object_id
  end

  it "ok" do
    expect(1).to eq 1
  end
end
